package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;

import javax.enterprise.event.Observes;

public class EmailService {
    public void sendWelcomeEmail(@Observes Customer customer){
        // write code
        System.out.println("Email");
    }
}
