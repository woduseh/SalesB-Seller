package handong.capstone2019s.salesb.app.productsellerlist;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import com.github.dozermapper.core.Mapper;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import handong.capstone2019s.salesb.domain.model.SellerProduct;
import handong.capstone2019s.salesb.domain.service.seller.SellerProductUpdateInput;
import handong.capstone2019s.salesb.domain.service.seller.SellerProductUpdateOutput;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "sellerProductList")
@SessionAttributes(types = SellerProduct.class)
@TransactionTokenCheck(value = "sellerProductList")
public class SellerProductListController {
	@Inject
	SellerService sellerService;

	@Inject
	Mapper beanMapper;

	@Inject
	SellerProductListHelper sellerProductListHelper;

	/* @Inject */
	SellerProductUpdateInput input;

	private final String path = "http://133.130.99.248/webdav/";
	private Sardine sardine = SardineFactory.begin("capstone2019s","pw.capstone2019s");


	@RequestMapping(method = RequestMethod.GET)
	public String SellerProductController(Authentication authentication, @ModelAttribute @Valid SellerProductListForm product, BindingResult result,
			Model model, @PageableDefault Pageable pageable) {
		if (result.hasErrors()) {
			return "seller/form";
		}
		if (log.isDebugEnabled()) {
            log.debug("pageable={}", pageable);
        }
		
		String sellerCode = authentication.getName();
		
		product.setSellerCode(sellerCode);
		
		SellerProduct criteria = beanMapper.map(product, SellerProduct.class);

		Page<SellerProduct> page = sellerService.showProduct(criteria, pageable);
		model.addAttribute("page", page);

		return "seller/product";
	}

	@ModelAttribute("SellerStoreListForm")
	public SellerProductListForm setUpSearchSellerProductListForm() {
		SellerProductListForm sellerStoreListForm = new SellerProductListForm();

		return sellerStoreListForm;
	}

	@RequestMapping(value = "seller/product", method = RequestMethod.GET)
	public String Search(@ModelAttribute @Valid SellerProductListForm sellerlist,
			BindingResult result, Model model, @PageableDefault Pageable pageable) {
		log.info("initial view");

		if (result.hasErrors()) {
			return "seller/product";
		}

		if (log.isDebugEnabled()) {
			log.debug("pageable={}", pageable);
		}

		SellerProduct criteria = beanMapper.map(sellerlist, SellerProduct.class);
		Page<SellerProduct> page = sellerService.showProduct(criteria, pageable);

		return "seller/product";

	}
	/* cancel */
	@RequestMapping(value = "{productCode}", method = RequestMethod.GET)
	public String detailForm(@PathVariable("productCode") String productCode, Model model) {
		SellerProductListForm output = sellerProductListHelper.findDetail(productCode);
		model.addAttribute("output", output);
		return "seller/detailForm";
	}

	@TransactionTokenCheck(value = "cancel", type = TransactionTokenType.BEGIN)
	@RequestMapping(value = "{productCode}/cancel", method = RequestMethod.GET)
	public String cancelConfirm(@PathVariable("productCode") String productCode, Model model) {
		SellerProductListForm output = sellerProductListHelper.findDetail(productCode);
		model.addAttribute("output", output);
		return "seller/cancelConfirm";
	}

	@TransactionTokenCheck(value = "cancel", type = TransactionTokenType.IN)
	@RequestMapping(value = "{productCode}/cancel", method = RequestMethod.POST)
	public String cancel(@PathVariable("productCode") String productCode, Model model,
			RedirectAttributes redirectAttr) {
		try {
			sellerService.cancel(productCode);
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return cancelConfirm(productCode, model);
		}
		return "redirect:/sellerProductList/{productCode}/cancel?complete";
	}

	/**
	 * redirects to the update completion page
	 *
	 * @return
	 */
	@RequestMapping(value = "{productCode}/cancel", method = RequestMethod.GET, params = "complete")
	public String cancelComplete(@PathVariable("productCode") String productCode, Model model) {
		model.addAttribute("productCode", productCode);
		return "seller/cancelComplete";
	}

	@RequestMapping(value = "{productCode}/cancel", method = RequestMethod.POST, params = "backTolist")
	public String backList() {
		return "redirect:/sellerProductList";
	}

	/* update */
	@RequestMapping(value = "{productCode}/update", method = RequestMethod.GET, params = "form")
	public String updateForm(@PathVariable("productCode") String productCode, SellerProductListForm form, Model model) {

		SellerProduct product = sellerService.findOne(productCode);
		beanMapper.map(product,form);

		model.addAttribute(product);
		return "seller/updateForm";
	}

	/**
	 * Goes back to the edit screen for user to make changes to the reservation.
	 *
	 * @param reserveNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "{productCode}/update", method = RequestMethod.POST, params = "redo")
	public String updateRedo(@PathVariable("productCode") String productCode, SellerProductListForm form, Model model) {
		SellerProduct product = sellerService.findOne(productCode);
		model.addAttribute(product);
		return "seller/updateForm";
	}

	/**
	 * Shows the confirmation page after user changes edits the reservation info on
	 * the edit reservation page
	 *
	 * @param model
	 * @return
	 */
	@TransactionTokenCheck(value = "update", type = TransactionTokenType.BEGIN)
	@RequestMapping(value = "{productCode}/update", method = RequestMethod.POST, params = "confirm")
	public String updateConfirm(@PathVariable("productCode") String productCode, @Validated SellerProductListForm output,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return updateRedo(productCode, output, model);
		}

		input = beanMapper.map(output,
				  SellerProductUpdateInput.class);
		output = sellerProductListHelper.findDetail(productCode);
		model.addAttribute("output", output);

		return "seller/updateConfirm";
	}

	/**
	 * Updates the reservation after user changes edits the reservation info on the
	 * edit reservation page
	 *
	 * @param form
	 * @return
	 */
	@TransactionTokenCheck(value = "update", type = TransactionTokenType.IN)
	@RequestMapping(value = "{productCode}/update", method = RequestMethod.POST)
	public String update(@PathVariable("productCode") String productCode, @Validated SellerProductListForm form,
			BindingResult result, Model model, RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return updateRedo(productCode, form, model);
		}
		SellerProductUpdateOutput output = beanMapper.map(input,
				SellerProductUpdateOutput.class);

		output.setProductCode(productCode);

		form = sellerService.update(output);

		redirectAttr.addFlashAttribute("output",form);

		return "redirect:/sellerProductList/{productCode}/update?complete";
	}


	/**
	 * redirects to the update completion page
	 *
	 * @return
	 */
	@RequestMapping(value = "{productCode}/update", method = RequestMethod.GET, params = "complete")
	public String updateComplete() {
		return "seller/updateComplete";
	}

	@RequestMapping(value = "{productCode}/update", method = RequestMethod.POST, params = "backTolist")
	public String updateBackList() {
		return "redirect:/sellerProductList";
	}
}
