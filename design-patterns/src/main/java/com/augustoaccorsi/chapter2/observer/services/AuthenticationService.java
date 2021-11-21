package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;
import com.augustoaccorsi.chapter2.observer.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class AuthenticationService {
    public void createAuthenticationCredentials(@Observes @Priority(100) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer){
        // write the authentication
        System.out.println("Authentication");
    }
}
