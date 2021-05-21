package handong.capstone2019s.salesb.app.productsellerinput;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class SellerProductInputForm implements Serializable{

    /**
     * serialVersion.
     */
    private static final long serialVersionUID = 2L;

    @NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productModel;

    @NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productBodyStyle;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$")
    private String productYear;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$")
    private String productMonth;

    @NotEmpty
    @Pattern(regexp = "^[0-9]+$")
    private String productPrice;

    @NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productMake;

    @NotEmpty
	/* @Pattern(regexp = "[0-9a-zA-Z]+") */
    private String productMileage;

    @NotEmpty
	/* @Pattern(regexp = "[0-9a-zA-Z]+") */
    private String productEngine;

    @NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productFuel;

    @NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productTransmission;

    @NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productColor;

	/* @Pattern(regexp = "^[a-zA-Z]+$") */
    private String productImageUrl;
    
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
                + "&productImageUrl=" + productImageUrl
                + "&sellerCode=" + sellerCode;
    }


}
