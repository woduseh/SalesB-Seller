package handong.capstone2019s.salesb.app.productsellerinput;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import com.github.dozermapper.core.Mapper;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import handong.capstone2019s.salesb.domain.model.SellerProduct;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "sellerProduct")
@SessionAttributes(types = SellerProduct.class)
@TransactionTokenCheck(value = "sellerProduct")
public class SellerProductInputController {

	@Inject
	SellerService sellerService;

	@Inject
	Mapper beanMapper;

	byte[] data=null;

    private final String path = "http://133.130.99.248/webdav/";
    private String imageUrl;
    private Sardine sardine = SardineFactory.begin("capstone2019s","pw.capstone2019s");

	/*
	 * @RequestMapping(method = RequestMethod.GET) public String
	 * SellerProductController(@ModelAttribute @Valid SellerProductForm product,
	 * BindingResult result, Model model, @PageableDefault Pageable pageable) { if
	 * (result.hasErrors()) { return "seller/form"; }
	 *
	 * SellerProduct criteria = beanMapper.map(product, SellerProduct.class);
	 *
	 * Date depDate = new LocalDate(product.getDepYear(), product .getDepMonth(),
	 * product.getDepDay()).toDate(); criteria.setDepDate(depDate);
	 *
	 * Page<SellerProduct> page = sellerService.showProduct(criteria, pageable);
	 * model.addAttribute("page", page);
	 *
	 * return "seller/product"; }
	 */
	/**
	 * pre-initialization of form backed bean
	 *
	 * @return
	 */
	@ModelAttribute
	public SellerProductInputForm setUpSellerProductForm() {
		SellerProductInputForm form = new SellerProductInputForm();
		log.debug("populate form {}", form);
		return form;
	}

	/**
	 * pre-initialization of form backed bean
	 *
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET, params = "form")
	public String createForm() {
		return "seller/createProductForm";
	}

	/**
	 * Return to main input screen
	 *
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST, params = "redo")
	public String createRedo(SellerProductInputForm form) {
		return "seller/createProductForm";
	}

	/**
	 * shows the confirmation screen before registering a new customer
	 *
	 * @param form
	 * @param result
	 * @return
	 */
	@TransactionTokenCheck(value = "create", type = TransactionTokenType.BEGIN)
	@RequestMapping(value = "create", method = RequestMethod.POST, params = "confirm")
	public String createConfirm(@Validated SellerProductInputForm form, BindingResult result) {
		form.setProductImageUrl(imageUrl);
		if (result.hasErrors()) {
			return createRedo(form);
		}

		try {
			sardine.put(form.getProductImageUrl(),data);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return "seller/createProductConfirm";
	}

	/**
	 * registers a new customer
	 *
	 * @param form
	 * @param result
	 * @param redirectAttr
	 * @return
	 */
	@TransactionTokenCheck(value = "create", type = TransactionTokenType.IN)
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(Authentication authentication, @Validated SellerProductInputForm form, BindingResult result, RedirectAttributes redirectAttr) {
		
		String sellerCode = authentication.getName();
		
		form.setProductImageUrl(imageUrl);
		if (result.hasErrors()) {
			return createRedo(form);
		}

		SellerProduct product = beanMapper.map(form, SellerProduct.class);

		SellerProduct registeredSeller = sellerService.register(product, sellerCode);

		redirectAttr.addFlashAttribute(registeredSeller);
		try {
			sardine.put(form.getProductImageUrl(),data);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return "redirect:/sellerProduct/create?complete";
	}

    @RequestMapping(value="upload",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String upload() {
    	System.out.println("upload start");
    	JFileChooser choice=new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images",
                "jpg", "gif");
    	choice.setFileFilter(filter);




    	int select=choice.showOpenDialog(null);
//    	if(select!=JFileChooser.APPROVE_OPTION) {
//
//    	}
    	String filePath=choice.getSelectedFile().getPath();
    	String name=choice.getSelectedFile().getName();
    	System.out.println(filePath);


//		}



		try{
			data = FileUtils.readFileToByteArray(new File(filePath));
			imageUrl=path+name;


      } catch (IOException e) {
          e.printStackTrace();

      }
        return "seller/createProductForm"; // 

    }


	/**
	 * Redirected to the result page after registering a customer
	 *
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET, params = "complete")
	public String createComplete() {
		return "seller/createProductsComplete";
	}

}
