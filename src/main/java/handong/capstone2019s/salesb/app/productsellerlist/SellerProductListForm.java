package handong.capstone2019s.salesb.app.productsellerlist;

import java.io.Serializable;

import lombok.Data;

@Data
public class SellerProductListForm implements Serializable{

    /**
     * serialVersion.
     */
    private static final long serialVersionUID = 2L;

    private String productModel;

    private String productBodyStyle;

    private String productYear;

    private String productMonth;

    private String productPrice;

    private String productMake;

    private String productMileage;

    private String productEngine;

    private String productFuel;

    private String productTransmission;

    private String productColor;

    private String productImageUrl;

    private String productCode;
    
    private String sellerCode;

    @Override
    public String toString() {
        return "&productModel=" + productModel
                + "&productBodyStyle=" + productBodyStyle
                + "&productYear=" + productYear + "&productMonth=" + productMonth
                + "&productPrice=" + productPrice + "&productMake=" + productMake
                + "&productMileage=" + productMileage
                + "&productEngine=" + productEngine
                + "&productFuel=" + productFuel
                + "&productTransmission=" + productTransmission
                + "&productColor=" + productColor
                + "&productImageUrl"+ productImageUrl
                + "&productCode=" + productCode;
    }

}
