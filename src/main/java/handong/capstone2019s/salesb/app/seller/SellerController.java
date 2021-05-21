package handong.capstone2019s.salesb.app.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/seller")
public class SellerController {
	
	/** show the seller page 
	 *  @return
	 */
	
	@RequestMapping
	public String sellerForm() {
		log.info("test view");
		return "seller/form";
	}
}
