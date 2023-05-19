package com.z.platform.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.z.platform.model.User;

public class CustomUserDetails implements UserDetails {

	
	private static final long serialVersionUID = 1L;
	private User user;
    
    public CustomUserDetails(User user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	 Collection < ? extends GrantedAuthority> mapRoles =user.getRoles().stream()
                 .map(role -> new SimpleGrantedAuthority(role.getName().substring(5)))
                 .collect(Collectors.toList());
         return mapRoles;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getName();
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
    public String getDob() {
    	return user.getDob();
    }
    public String getNationality() {
    	return user.getNationality();
    }

}
