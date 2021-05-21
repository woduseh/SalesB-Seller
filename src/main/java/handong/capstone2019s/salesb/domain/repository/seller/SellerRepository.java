package handong.capstone2019s.salesb.domain.repository.seller;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import handong.capstone2019s.salesb.app.customerrequest.CustomerRequestForm;
import handong.capstone2019s.salesb.app.requesttoadmin.SellerRequestToAdminForm;
import handong.capstone2019s.salesb.domain.model.Customer;
import handong.capstone2019s.salesb.domain.model.Request;
import handong.capstone2019s.salesb.domain.model.RequestToSeller;
import handong.capstone2019s.salesb.domain.model.Seller;
import handong.capstone2019s.salesb.domain.model.SellerCustomer;
import handong.capstone2019s.salesb.domain.model.SellerProduct;

public interface SellerRepository {

    Optional<Seller> findBySellerId(String sellerCode);
    
    Optional<SellerProduct> findByProductId(String productCode);

    void insertseller(Seller seller);

    void insertproduct(@Param("product")SellerProduct product, @Param("sellerCode")String sellerCode);
    
    void deleteById(String productCode);
    
    void update(SellerProduct product);
    
    void insertRequest(SellerRequestToAdminForm request);
    
    void insertcustomer(Customer customer);
    
    void insertsellercustomer (SellerCustomer sellercustomer);

    void updateCustomer(RequestToSeller requestToseller);
    void updateSeller(Seller seller);
    List<SellerProduct> showSellerProduct(
            @Param("product") SellerProduct product,
            @Param("pageable") Pageable pageable);

    List<Seller> showSeller(
            @Param("seller") Seller seller,
            @Param("pageable") Pageable pageable);

    long countBySeller(
    		@Param("seller") Seller seller);

    long countBySellerProduct(
            @Param("product") SellerProduct product);
    
    long countByRequestToSeller(
    		@Param("requestToSeller") RequestToSeller requestToSeller);
    
    List<RequestToSeller> showRequestToSeller(
    		@Param("requestToSeller") RequestToSeller requestToSeller,
    		@Param("pageable") Pageable pageable);
    
    List<Request> selectCustomerRequestbySellerName(@Param("thePersonInCharge") String sellerName, @Param("requestform") CustomerRequestForm request, Pageable pageable);

    List<Request> selectCustomerRequestbySeq(@Param("seq") int seq, Pageable pageable);
    
    long countCustomerRequestbySellerName (@Param("thePersonInCharge") String sellerName, @Param("requestform") CustomerRequestForm request);

}
