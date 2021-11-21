package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;
import com.augustoaccorsi.chapter2.observer.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class EmailService {
    public void sendWelcomeEmail(@Observes @Priority(1_000) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer){
        // write code
        System.out.println("Email");
    }
}
