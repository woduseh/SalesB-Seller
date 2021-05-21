package handong.capstone2019s.salesb.domain.service.customerrequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import handong.capstone2019s.salesb.app.customerrequest.CustomerRequestForm;
import handong.capstone2019s.salesb.domain.model.Request;

public interface CustomerRequestService {

	Page<Request> showCustomerRequest(CustomerRequestForm request, String sellerName, Pageable pageable);
	
	Page<Request> showCustomerRequestDetail(int seq, Pageable pageable);
}
