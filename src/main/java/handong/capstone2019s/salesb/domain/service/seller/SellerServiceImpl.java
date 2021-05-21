/*
 * Copyright(c) 2013 NTT DATA Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package handong.capstone2019s.salesb.domain.service.seller;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.github.dozermapper.core.Mapper;

import handong.capstone2019s.salesb.app.manageseller.SellerForm;
import handong.capstone2019s.salesb.app.productsellerlist.SellerProductListForm;
import handong.capstone2019s.salesb.app.requesttoadmin.SellerRequestToAdminForm;
import handong.capstone2019s.salesb.app.setting.SellerSettingForm;
import handong.capstone2019s.salesb.domain.common.constants.MessageId;
import handong.capstone2019s.salesb.domain.model.Customer;
import handong.capstone2019s.salesb.domain.model.Request;
import handong.capstone2019s.salesb.domain.model.RequestToSeller;

import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.model.SellerCustomer;
import handong.capstone2019s.salesb.domain.model.SellerProduct;
import handong.capstone2019s.salesb.domain.repository.seller.SellerRepository;

@Transactional
@Service
public class SellerServiceImpl implements SellerService {
    @Inject
    SellerRepository sellerRepository;


    @Inject
    PasswordEncoder passwordEncoder;
    
    @Inject
	Mapper beanMapper;

    @Override
    public Seller register(Seller seller, String rawPassword) {

        String password = passwordEncoder.encode(rawPassword);

        seller.setSellerPass(password);
        sellerRepository.insertseller(seller);
        return seller;
    }

	@Override
	public Page<SellerProduct> showProduct(SellerProduct product, Pageable pageable) {
	     long total = sellerRepository.countBySellerProduct(product);
	        List<SellerProduct> content;
	        if (0 < total) {
	            content = sellerRepository.showSellerProduct(product,
	                    pageable);
	        } else {
	            content = Collections.emptyList();
	        }

	        Page<SellerProduct> page = new PageImpl<SellerProduct>(content, pageable, total);
	        return page;
	}

	@Override
	public SellerProduct register(SellerProduct product, String sellerCode) {
		sellerRepository.insertproduct(product, sellerCode);
		return product;
	}
	
	@Override
	public Page<Seller> showSeller(Seller seller, Pageable pageable) {
	     long total = sellerRepository.countBySeller(seller);
	        List<Seller> content;
	        if (0 < total) {
	            content = sellerRepository.showSeller(seller,
	                    pageable);
	        } else {
	            content = Collections.emptyList();
	        }

	        Page<Seller> page = new PageImpl<Seller>(content, pageable, total);
	        return page;
	}
	
	@Override
	public void cancel(String productCode) throws BusinessException {
		SellerProduct product = findOne(productCode);

		if (product != null) {
			sellerRepository.deleteById(productCode);
		} else {
			ResultMessages message = ResultMessages.error().add(MessageId.E_TR_0003);
			throw new BusinessException(message);
		}
		/* log.debug("canceled productCode={}", productCode); */
	}

	@Override
	public SellerProductListForm update(SellerProductUpdateOutput output) throws BusinessException {
		 SellerProduct product = findOne(output.getProductCode());
		 
		 beanMapper.map(output, product); 

		 sellerRepository.update(product);

		  SellerProductListForm input = new SellerProductListForm();
		  
		  input.setProductBodyStyle(product.getProductBodyStyle());
		  input.setProductColor(product.getProductColor());
		  input.setProductEngine(product.getProductEngine());
		  input.setProductFuel(product.getProductFuel());
		  input.setProductMake(product.getProductMake());
		  input.setProductMileage(product.getProductMileage());
		  input.setProductModel(product.getProductModel());
		  input.setProductMonth(product.getProductModel());
		  input.setProductPrice(product.getProductPrice());
		  input.setProductTransmission(input.getProductPrice());
		  input.setProductYear(product.getProductYear());
	
		 return input; 
	}
	
	@Override
	public SellerProduct findOne(String productCode) {
		return sellerRepository.findByProductId(productCode).orElse(null);
	}
	
	@Override
	public Page<RequestToSeller> showRequestToSeller(RequestToSeller requestToSeller, Pageable pageable){
		long total= sellerRepository.countByRequestToSeller(requestToSeller);
		
		List<RequestToSeller> content;
		if(0< total) {
			content= sellerRepository.showRequestToSeller(requestToSeller,
					pageable);
		}else {
			content= Collections.emptyList();
		}
		
		Page<RequestToSeller> page= new PageImpl<RequestToSeller>(content, pageable, total);
		return page;
	}
	
	@Override
	public SellerRequestToAdminForm registerRequest (SellerRequestToAdminForm request) {		
		sellerRepository.insertRequest(request);
		
		return request;
	}

	@Override
	public Seller findByCode(String seller_code) {
		Seller seller = sellerRepository.findBySellerId(seller_code).orElse(null);
		return seller;
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		sellerRepository.insertcustomer(customer);
		return customer;
	}

	@Override
	public RequestToSeller updateCustomer(RequestToSeller requestToSeller) {
		 sellerRepository.updateCustomer(requestToSeller);
		return null;
	}

	@Override
	public SellerSettingForm updateSeller(SellerSettingForm seller, String sellerCode) {
		Seller seller_by_code = findByCode(sellerCode);
		
		/* SellerProduct product = findOne(output.getProductCode()); */
		 
		 beanMapper.map(seller, seller_by_code); 

		 sellerRepository.updateSeller(seller_by_code);
		/*
		 * SellerProductListForm input = new SellerProductListForm();
		 * 
		 * input.setProductBodyStyle(product.getProductBodyStyle());
		 * input.setProductColor(product.getProductColor());
		 * input.setProductEngine(product.getProductEngine());
		 * input.setProductFuel(product.getProductFuel());
		 * input.setProductMake(product.getProductMake());
		 * input.setProductMileage(product.getProductMileage());
		 * input.setProductModel(product.getProductModel());
		 * input.setProductMonth(product.getProductModel());
		 * input.setProductPrice(product.getProductPrice());
		 * input.setProductTransmission(input.getProductPrice());
		 * input.setProductYear(product.getProductYear());
		 */
		return null;
	}

	@Override
	public SellerCustomer registerSellerCustomer(SellerCustomer sellercustomer) {
		sellerRepository.insertsellercustomer(sellercustomer);
		return null;
	}	
	
}
