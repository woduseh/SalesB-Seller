package handong.capstone2019s.salesb.domain.service.authority;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import handong.capstone2019s.salesb.domain.model.Seller;

public class AuthoritySellerDetails implements UserDetails{
    private static final long serialVersionUID = 1L;

    private static final List<? extends GrantedAuthority> DEFAULT_AUTHORITIES = AuthorityUtils
            .createAuthorityList("ROLE_SELLER");

    private final Seller seller;

    public AuthoritySellerDetails(Seller seller) {
        this.seller = seller;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return DEFAULT_AUTHORITIES;
    }

    @Override
    public String getPassword() {
        return this.seller.getSellerPass();
    }

    @Override
    public String getUsername() {
        return this.seller.getSellerCode();
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
