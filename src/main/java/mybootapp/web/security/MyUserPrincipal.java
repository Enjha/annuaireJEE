package mybootapp.web.security;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mybootapp.model.XUser;

public class MyUserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;

    private XUser user;

    public MyUserPrincipal(XUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorites = new LinkedList<GrantedAuthority>();
        user.getRoles().forEach((role) -> {
            authorites.add(new SimpleGrantedAuthority(role));
        });
        return authorites;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
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