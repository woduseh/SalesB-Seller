package handong.capstone2019s.salesb.app.setting;

import javax.inject.Inject;

import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;

public class SellerSettingHelper {
	@Inject
    SellerService sellerService;
    public SellerSettingForm findDetail(String sellerCode) {
    	System.out.println("sellerCode"+sellerCode);
        Seller seller = sellerService.findByCode(sellerCode);

        SellerSettingForm form = new SellerSettingForm();

        form.setSellerName(seller.getSellerName());
		form.setSellerMail(seller.getSellerMail());
		form.setSellerTel(seller.getSellerTel());
		form.setSellerInformation(seller.getSellerInformation());
		form.setSellerImageURL(seller.getSellerImageURL()); 
		 
        return form;

    }

	

}
