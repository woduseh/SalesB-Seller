package handong.capstone2019s.salesb.app.requesttoadmin;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import com.github.dozermapper.core.Mapper;

import handong.capstone2019s.salesb.domain.model.Request;
import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/requestToAdmin")
@SessionAttributes(types = Request.class)
//@TransactionTokenCheck(value = "sellerProduct")
public class SellerRequestToAdmin {

	@Inject
	SellerService sellerService;

	@Inject
	Mapper beanMapper;

	/**
	 * @return
	 */
	@ModelAttribute
	public SellerRequestToAdminForm setUpSellerRequestToAdminForm() {
		SellerRequestToAdminForm form = new SellerRequestToAdminForm();
		log.debug("populate form {}", form);
		return form;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET, params = "form")
	public String createForm() {
		return "seller/createRequestToAdminForm";
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST, params = "redo")
	public String createRedo(SellerRequestToAdminForm form) {
		return "seller/createRequestToAdminForm";
	}

	/**
	 * @param form
	 * @param result
	 * @return
	 */
	@TransactionTokenCheck(value = "create", type = TransactionTokenType.BEGIN)
	@RequestMapping(value = "create", method = RequestMethod.POST, params = "confirm")
	public String createConfirm(@Validated SellerRequestToAdminForm form, BindingResult result) {
		if (result.hasErrors()) {
			return createRedo(form);
		}
		return "seller/createRequestToAdminConfirm";
	}

	/**
	 * @param form
	 * @param result
	 * @param redirectAttr
	 * @return
	 */
	@TransactionTokenCheck(value = "create", type = TransactionTokenType.IN)
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Authentication authentication, @Validated SellerRequestToAdminForm form, BindingResult result, RedirectAttributes redirectAttr) {

		String sellerCode = authentication.getName();
		
		Seller seller = sellerService.findByCode(sellerCode);
		form.setThePersonInCharge(seller.getSellerManageAdmin());
		form.setClient(seller.getSellerName());
		
		
		if (result.hasErrors()) { return createRedo(form); }
		 

		SellerRequestToAdminForm request = beanMapper.map(form, SellerRequestToAdminForm.class);

		SellerRequestToAdminForm registeredRequest = sellerService.registerRequest(request);

		redirectAttr.addFlashAttribute(registeredRequest);

		return "redirect:/requestToAdmin/create?complete";
	}

	/**
	 * Redirected to the result page after registering a customer
	 * 
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET, params = "complete")
	public String createComplete() {
		return "seller/createRequestToAdminComplete";
	}

}
