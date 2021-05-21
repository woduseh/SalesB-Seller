package handong.capstone2019s.salesb.app.manageseller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SellerPassEqualsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return (SellerForm.class).isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SellerForm seller = (SellerForm) target;
        String pass = seller.getSellerPass();
        String passConfirm = seller.getSellerPassConfirm();
        if (pass == null || passConfirm == null) {
            // must be checked by @NotEmpty
            return;
        }
        if (!pass.equals(passConfirm)) {
            errors.rejectValue("sellerPass", "NotEquals.sellerPass",
                    "Password and password confirm is not same.");
        }
    }
}
