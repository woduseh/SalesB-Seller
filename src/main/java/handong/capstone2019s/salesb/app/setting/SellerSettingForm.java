package handong.capstone2019s.salesb.app.setting;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SellerSettingForm implements Serializable{

    /**
     * serialVersion.
     */
    private static final long serialVersionUID = 1L;

	/* @NotEmpty */
    @Size(max = 20)
    @Pattern(regexp = "^[a-zA-Z가-힣]+$")
    private String sellerName;
    
    @Email
    @Pattern(regexp="[a-zA-Z0-9]+@[a-z]+.[a-z]+$")
    @Size(max = 30)
    private String sellerMail;

	/*
	 * @NotEmpty
	 * 
	 * @Pattern(regexp = "[0-9a-zA-Z]+")
	 * 
	 * @Size(min = 4, max = 20) private String sellerPass;
	 * 
	 * @NotEmpty
	 * 
	 * @Pattern(regexp = "[0-9a-zA-Z]+")
	 * 
	 * @Size(min = 4, max = 20) private String sellerPassConfirm;
	 */

    @Pattern(regexp = "[0-9-]+[0-9]+$")
    @Size(min = 10, max = 13)
    private String sellerTel;
    
    private String sellerInformation;
    
    private String sellerImageURL;
    
    private String sellerCode;

    @Override
    public String toString() {
        return "&sellerName=" + sellerName
                + "&sellerMail=" + sellerMail
				/*
				 * + "&sellerPass=" + sellerPass + "&sellerPassConfirm=" + sellerPassConfirm
				 */
                + "&sellerTel=" + sellerTel +"&sellerInformation"+sellerInformation
                +"&sellerImageURL"+sellerImageURL +"&sellerCode"+sellerCode;
    }
	
	

}
