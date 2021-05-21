package handong.capstone2019s.salesb.app.requesttoseller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;

import com.github.dozermapper.core.Mapper;

import handong.capstone2019s.salesb.domain.model.RequestToSeller;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "requestToSellerList")
@SessionAttributes(types = RequestToSeller.class)
@TransactionTokenCheck(value = "requestToSellerList")
public class RequestToSellerListController {
	@Inject
	SellerService sellerService;
	
	@Inject
	Mapper beanMapper;
	
	@RequestMapping(method= RequestMethod.GET)
	public String RequestToSellerController(@ModelAttribute @Valid RequestToSellerListForm requestToSeller,
			BindingResult result, Model model, @PageableDefault Pageable pageable) {
		if(result.hasErrors()) {
			return "seller/form";
		}
		RequestToSeller criteria= beanMapper.map(requestToSeller, RequestToSeller.class);
		
		Page<RequestToSeller> page= sellerService.showRequestToSeller(criteria, pageable);
		model.addAttribute("page", page);
		
		return "seller/requestToSeller";
	}
}
