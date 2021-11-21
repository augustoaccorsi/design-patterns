package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;

import javax.enterprise.event.Observes;

public class AuthenticationService {
    public void createAuthenticationCredentials(@Observes Customer customer){
        // write the authentication
        System.out.println("Authentication");
    }
}
