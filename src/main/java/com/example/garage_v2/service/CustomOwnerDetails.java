package com.example.garage_v2.service;

import com.example.garage_v2.model.OwnerRegistration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomOwnerDetails implements UserDetails {

    private final OwnerRegistration ownerRegistration;

    public CustomOwnerDetails(OwnerRegistration ownerRegistration) {
        this.ownerRegistration = ownerRegistration;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
