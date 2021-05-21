package handong.capstone2019s.salesb.app.setting;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.inject.Inject;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import com.github.dozermapper.core.Mapper;
import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SellerSettingController {

	@Inject
	SellerService sellerService;

	@Inject
	Mapper beanMapper;
	
	/* @Inject */
	SellerSettingHelper sellersettinghelper;
	
	SellerSettingForm sellerCheck = new SellerSettingForm();
	
	private final String path = "http://133.130.99.248/webdav/";
    private String imageUrl;
    private Sardine sardine = SardineFactory.begin("capstone2019s","pw.capstone2019s");
    byte[] data=null;
	
	@RequestMapping(value = "/Setting/{sellerCode}", method = RequestMethod.GET)
	public String sellerSetting(@PathVariable("sellerCode") String sellerCode, Principal principal, Model model) {
		Seller seller = sellerService.findByCode(sellerCode);
		model.addAttribute("output", seller);

		return "setting/sellerSetting";
	}

	/* update */
	
	  @RequestMapping(value = "/Setting/{sellerCode}/update", method = RequestMethod.GET, params = "form") 
	  public String updateForm(@PathVariable("sellerCode") String sellerCode, SellerSettingForm form, Model model) {
	  
	  Seller output = sellerService.findByCode(sellerCode);
	  beanMapper.map(output,form);
	  
	  model.addAttribute(output); 
	  return "setting/updateForm"; 
	  }
	  
	 
	
	/**
		 * Goes back to the edit screen for user to make changes to the reservation.
		 *
		 * @param reserveNo
		 * @param model
		 * @return
		 */
	
	
	  @RequestMapping(value = "/Setting/{sellerCode}/update", method =RequestMethod.POST, params = "redo") 
	  public String updateRedo(@PathVariable("sellerCode") String sellerCode, SellerSettingForm form, Model model) { 
		  Seller output = sellerService.findByCode(sellerCode);
		  model.addAttribute(output);
	  
	  return "setting/updateForm"; 
	  }
	 
	  
	  @RequestMapping(value="/Setting/{sellerCode}/uploadSeller",method = RequestMethod.GET)
	  @ResponseStatus(HttpStatus.OK)
	    public String upload(@PathVariable("sellerCode") String sellerCode,SellerSettingForm form,Model model) {
		  Seller output = sellerService.findByCode(sellerCode);
		  beanMapper.map(output,form);
			
	    	System.out.println("upload seller start");
	    	JFileChooser choice=new JFileChooser();
	    	FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                "JPG & GIF Images",
	                "jpg", "gif");
	    	choice.setFileFilter(filter);


	    	int select=choice.showOpenDialog(null);

	    	String filePath=choice.getSelectedFile().getPath();
	    	String name=choice.getSelectedFile().getName();
	    	System.out.println(filePath);

			try{
				data = FileUtils.readFileToByteArray(new File(filePath));
				imageUrl=path+name;


	      } catch (IOException e) {
	          e.printStackTrace();

	      }
		 return "setting/updateForm"; //check

	    }
	 
	  
	  /**
		 * Shows the confirmation page after user changes edits the reservation info on
		 * the edit reservation page
		 *
		 * @param model
		 * @return
		 */
	
	  @TransactionTokenCheck(value = "update", type = TransactionTokenType.BEGIN)
	  @RequestMapping(value = "/Setting/{sellerCode}/update", method = RequestMethod.POST, params = "confirm") 
	  public String updateConfirm(@PathVariable("sellerCode") String sellerCode, @Validated SellerSettingForm form, BindingResult result, Model model) { 
		  form.setSellerImageURL(imageUrl);
		  if (result.hasErrors()){ 
			  return updateRedo(sellerCode, form, model); 
			}
		/*
		 * Seller seller = sellerService.findByCode(sellerCode);
		 * beanMapper.map(seller,form);
		 */
		/* input = beanMapper.map(form, SellerProductUpdateInput.class); */
		/*
		 * if(form != null) { form = sellersettinghelper.findDetail(sellerCode); }
		 */
		  beanMapper.map(form,sellerCheck);
		  model.addAttribute("output", form);
		  
		  try {
			/* sardine.put(path+"auth.jpg",data); */
			  sardine.put(sellerCheck.getSellerImageURL(),data);

			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	  
	  return "setting/updateConfirm"; 
	  }
	  
	  /**
		 * Updates the reservation after user changes edits the reservation info on the
		 * edit reservation page
		 *
		 * @param form
		 * @return
		 */
	
	  @TransactionTokenCheck(value = "update", type = TransactionTokenType.IN)  
	  @RequestMapping(value = "/Setting/{sellerCode}/update", method = RequestMethod.POST) 
	  public String update(@PathVariable("sellerCode") String sellerCode, @Validated SellerSettingForm form, BindingResult result, Model model, 
			  RedirectAttributes redirectAttr) { 
		  form.setSellerImageURL(imageUrl);
		  if (result.hasErrors()) { 
			  return updateRedo(sellerCode, form, model); 
		} 
		/*
		 * SellerProductUpdateOutput output = beanMapper.map(input,
		 * SellerProductUpdateOutput.class);
		 * 
		 * output.setProductCode(sellerCode);
		 */
	  beanMapper.map(sellerCheck, form);
		/* System.out.println(form.getSellerInformation()+" check ~!"); */
	  form = sellerService.updateSeller(form,sellerCode);
	  
	  redirectAttr.addFlashAttribute("output",form);
	  try {
			/* sardine.put(sellerCheck.getSellerImageURL(),data); */
		  sardine.put(path+"auth.jpg",data);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	  
	  return "redirect:/Setting/{sellerCode}/update?complete"; 
	  }
	  
	  
	 
	  
	  /**
		 * redirects to the update completion page
		 *
		 * @return
		 */
	  
	  
	  @RequestMapping(value = "/Setting/{sellerCode}/update", method = RequestMethod.GET, params = "complete") 
	  public String updateComplete() {
		  return "setting/updateComplete"; 
	  }
	  
	
	  @RequestMapping(value = "/Setting/{sellerCode}/update", method =RequestMethod.POST, params = "backTolist") 
	  public String updateBackList(@PathVariable("sellerCode") String sellerCode) {
		  return "redirect:/Setting/{sellerCode}/update"; 
	  }
	  

}
