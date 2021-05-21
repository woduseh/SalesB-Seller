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
package handong.capstone2019s.salesb.domain.service.customerrequest;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import handong.capstone2019s.salesb.app.customerrequest.CustomerRequestForm;
import handong.capstone2019s.salesb.domain.model.Request;
import handong.capstone2019s.salesb.domain.repository.seller.SellerRepository;

@Transactional
@Service
public class CustomerRequestServiceImpl implements CustomerRequestService {
	@Inject
	SellerRepository sellerRepository;

	@Inject
	PasswordEncoder passwordEncoder;

	@Override
	public Page<Request> showCustomerRequest(CustomerRequestForm request, String sellerName, Pageable pageable) {

		long total = sellerRepository.countCustomerRequestbySellerName(sellerName, request);
		List<Request> content;

		if (0 < total) {
			content = sellerRepository.selectCustomerRequestbySellerName(sellerName, request, pageable);
		} else {
			content = Collections.emptyList();
		}

		Page<Request> page = new PageImpl<Request>(content, pageable, total);
		return page;
	}

	@Override
	public Page<Request> showCustomerRequestDetail(int seq, Pageable pageable){
		
		List<Request> content = sellerRepository.selectCustomerRequestbySeq(seq, pageable);
		
		Page<Request> page = new PageImpl<Request>(content, pageable, 1);
		return page;
	}
}
