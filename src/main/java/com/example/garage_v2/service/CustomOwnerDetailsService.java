package com.example.garage_v2.service;

import com.example.garage_v2.model.OwnerRegistration;
import com.example.garage_v2.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomOwnerDetailsService implements UserDetailsService {


    @Autowired
    private RegistrationRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OwnerRegistration ownerRegistration = repository.getByName(username);
        if (ownerRegistration == null) {
            throw new UsernameNotFoundException("User with name " + username + " not found!");
        }
        return new CustomOwnerDetails(ownerRegistration);
    }
}
