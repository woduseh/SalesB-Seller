package handong.capstone2019s.salesb.app.customerrequest;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.dozermapper.core.Mapper;

import handong.capstone2019s.salesb.domain.model.Request;
import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.repository.seller.SellerRepository;
import handong.capstone2019s.salesb.domain.service.authority.AuthoritySellerDetails;
import handong.capstone2019s.salesb.domain.service.customerrequest.CustomerRequestService;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;

@Slf4j
@Controller
@SessionAttributes(types = Request.class)
public class CustomerRequestListController {

	@Inject
	SellerRepository sellerRepository;

	@Inject
	CustomerRequestService customerRequestService;
	SellerService sellerService;

	@Inject
	Mapper beanMapper;

	@RequestMapping(value = "customerRequest")
	public String RequestList(Authentication authentication, @ModelAttribute @Valid CustomerRequestForm request,
			BindingResult result, Model model, @PageableDefault Pageable pageable) {

		log.info("initial view");

		if (result.hasErrors()) {
			return "seller/customerRequestForm";
		}

		if (log.isDebugEnabled()) {
			log.debug("pageable={}", pageable);
		}

		AuthoritySellerDetails sellerDetail = (AuthoritySellerDetails) authentication.getPrincipal();
		
		Seller seller = sellerDetail.getSeller();

		CustomerRequestForm criteria = beanMapper.map(request, CustomerRequestForm.class);

		Page<Request> page = customerRequestService.showCustomerRequest(criteria, seller.getSellerName(), pageable);
		model.addAttribute("page", page);

		return "seller/customerRequestForm";
	}

	@ModelAttribute("CustomerRequestForm")
	public CustomerRequestForm setUpSearchCustomerRequestForm() {
		CustomerRequestForm customerRequestForm = new CustomerRequestForm();

		return customerRequestForm;
	}

	@RequestMapping(value = "customerRequest", method = RequestMethod.GET)
	public String Search(Authentication authentication, @ModelAttribute @Valid CustomerRequestForm request,
			BindingResult result, Model model, @PageableDefault Pageable pageable) {

		log.info("initial view");

		if (result.hasErrors()) {
			return "seller/customerRequestForm";
		}

		if (log.isDebugEnabled()) {
			log.debug("pageable={}", pageable);
		}

		AuthoritySellerDetails sellerDetail = (AuthoritySellerDetails) authentication.getPrincipal();
		
		Seller seller = sellerDetail.getSeller();

		CustomerRequestForm criteria = beanMapper.map(request, CustomerRequestForm.class);

		Page<Request> page = customerRequestService.showCustomerRequest(criteria, seller.getSellerName(), pageable);
		model.addAttribute("page", page);

		int pageSize = page.getNumberOfElements();

		model.addAttribute("pageSize", pageSize);

		return "seller/customerRequestForm";
	}

	@RequestMapping(value = "customerRequestdetail", params = "requestnum", method = RequestMethod.GET)
	public String View(Model model, @PageableDefault Pageable pageable, @RequestParam("requestnum") int seq) {
		
		Page<Request> page = customerRequestService.showCustomerRequestDetail(seq, pageable);
		model.addAttribute("page", page);

		int pageSize = page.getNumberOfElements();

		model.addAttribute("pageSize", pageSize);

		return "seller/customerRequestView";
	}
}