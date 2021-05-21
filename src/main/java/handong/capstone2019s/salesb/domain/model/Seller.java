package handong.capstone2019s.salesb.domain.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Seller implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sellerCode;

    private String sellerName;
    
    private String sellerPass;

    private String sellerMail;

    private String sellerTel;
    
    private String sellerVersion;
    
    private String sellerManageAdmin;
    
    private String sellerInformation;
    
    private String sellerImageURL;
    
    public Seller(String sellerCode) {
        this.sellerCode = sellerCode;
    }

}
