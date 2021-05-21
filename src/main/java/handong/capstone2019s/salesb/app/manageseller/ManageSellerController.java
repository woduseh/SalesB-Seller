package handong.capstone2019s.salesb.app.manageseller;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import com.github.dozermapper.core.Mapper;

import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

/**
 * Handle request of customer register.
 */
@Slf4j
@Controller
@RequestMapping(value = "sellers")
@TransactionTokenCheck(value = "sellers")
public class ManageSellerController {

    @Inject
    SellerService sellerService;

    @Inject
    SellerPassEqualsValidator passwordEqualsValidator;

    @Inject
    Mapper beanMapper;

    @InitBinder("sellerForm")
    public void initBinder(WebDataBinder webDataBinder) {
        // add custom validators to default bean validations
        webDataBinder.addValidators(passwordEqualsValidator);
    }

    /**
     * pre-initialization of form backed bean
     * @return
     */
    @ModelAttribute
    public SellerForm setUpSellerForm() {
        SellerForm form = new SellerForm();
        log.debug("populate form {}", form);
        return form;
    }

    /**
     * pre-initialization of form backed bean
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET, params = "form")
    public String createForm() {
        return "manageuser/seller/createSellerForm";
    }

    /**
     * Return to main input screen
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.POST, params = "redo")
    public String createRedo(SellerForm form) {
        return "manageuser/seller/createSellerForm";
    }

    /**
     * shows the confirmation screen before registering a new customer
     * @param form
     * @param result
     * @return
     */
    @TransactionTokenCheck(value = "create", type = TransactionTokenType.BEGIN)
    @RequestMapping(value = "create", method = RequestMethod.POST, params = "confirm")
    public String createConfirm(@Validated SellerForm form,
            BindingResult result) {
        if (result.hasErrors()) {
            return createRedo(form);
        }
        return "manageuser/seller/createSellerConfirm";
    }

    /**
     * registers a new customer
     * @param form
     * @param result
     * @param redirectAttr
     * @return
     */
    @TransactionTokenCheck(value = "create", type = TransactionTokenType.IN)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Validated SellerForm form, BindingResult result,
            RedirectAttributes redirectAttr) {
        if (result.hasErrors()) {
            return createRedo(form);
        }

        Seller seller = beanMapper.map(form, Seller.class);

        Seller registeredSeller = sellerService.register(seller, form
                .getSellerPass());
        redirectAttr.addFlashAttribute(registeredSeller);
        return "redirect:/sellers/create?complete";
    }

    /**
     * Redirected to the result page after registering a customer
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET, params = "complete")
    public String createComplete() {
        return "manageuser/seller/createSellerComplete";
    }

}
