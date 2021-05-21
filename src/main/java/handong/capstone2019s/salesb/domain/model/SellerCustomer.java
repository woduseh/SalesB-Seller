package handong.capstone2019s.salesb.domain.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SellerCustomer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sellerCode;
    
    private String customerCode;
}
