package handong.capstone2019s.salesb.app.productsellerlist;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import handong.capstone2019s.salesb.domain.model.SellerProduct;
import handong.capstone2019s.salesb.domain.service.seller.SellerService;
@Component
public class SellerProductListHelper {
    @Inject
    SellerService sellerService;

    public SellerProductListForm findDetail(String productCode) {
        SellerProduct product = sellerService.findOne(productCode);

        SellerProductListForm form = new SellerProductListForm();

        form.setProductBodyStyle(product.getProductBodyStyle());
        form.setProductCode(product.getProductCode());
        form.setProductColor(product.getProductColor());
        form.setProductEngine(product.getProductEngine());
        form.setProductFuel(product.getProductFuel());
        form.setProductMake(product.getProductMake());
        form.setProductMileage(product.getProductMileage());
        form.setProductModel(product.getProductModel());
        form.setProductMonth(product.getProductMonth());
        form.setProductPrice(product.getProductPrice());
        form.setProductTransmission(product.getProductTransmission());
        form.setProductYear(product.getProductYear());
        form.setProductImageUrl(product.getProductImageUrl());

        return form;

    }



}
