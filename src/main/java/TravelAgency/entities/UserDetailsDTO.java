package TravelAgency.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsDTO implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // You can customize this logic based on your requirements
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // You can customize this logic based on your requirements
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // You can customize this logic based on your requirements
        return true;
    }

    @Override
    public boolean isEnabled() {
        // You can customize this logic based on your requirements
        return true;
    }
}
