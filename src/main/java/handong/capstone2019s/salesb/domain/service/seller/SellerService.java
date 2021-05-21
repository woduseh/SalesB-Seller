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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.terasoluna.gfw.common.exception.BusinessException;

import handong.capstone2019s.salesb.app.manageseller.SellerForm;
import handong.capstone2019s.salesb.app.productsellerlist.SellerProductListForm;
import handong.capstone2019s.salesb.app.requesttoadmin.SellerRequestToAdminForm;
import handong.capstone2019s.salesb.app.setting.SellerSettingForm;
import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.model.SellerCustomer;
import handong.capstone2019s.salesb.domain.model.SellerProduct;
import handong.capstone2019s.salesb.domain.service.authority.AuthoritySellerDetails;
import handong.capstone2019s.salesb.domain.model.Customer;
import handong.capstone2019s.salesb.domain.model.Request;
import handong.capstone2019s.salesb.domain.model.RequestToSeller;

public interface SellerService {
    Seller register(Seller seller, String rawPassword);
   
    SellerProduct register(SellerProduct product, String sellerCode);

    SellerProduct findOne(String productCode);
    
    Customer registerCustomer(Customer customer);
    
    RequestToSeller updateCustomer(RequestToSeller requestToSeller);
    
    SellerCustomer registerSellerCustomer (SellerCustomer sellercustomer);
    
    Page<SellerProduct> showProduct(SellerProduct product,
            Pageable pageable);

    Page<RequestToSeller> showRequestToSeller(RequestToSeller requestToSeller,
    		Pageable pageable);

    Page<Seller> showSeller(Seller seller,
            Pageable pageable);
    
    void cancel(String productCode) throws BusinessException;
    
    SellerProductListForm update(
    		SellerProductUpdateOutput input) throws BusinessException;
    
    SellerRequestToAdminForm registerRequest (SellerRequestToAdminForm request);
    
    Seller findByCode (String seller_code);
    
    SellerSettingForm updateSeller(SellerSettingForm seller, String sellerCode);
}
