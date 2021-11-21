package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class CustomerService {
    public void createCustomer(@Observes @Priority(10) Customer customer){
        // write code
        System.out.println("Customer");
    }
}
