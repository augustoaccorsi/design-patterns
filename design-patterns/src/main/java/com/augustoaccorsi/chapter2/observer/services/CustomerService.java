package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;

import javax.enterprise.event.Observes;

public class CustomerService {
    public void createCustomer(@Observes Customer customer){
        // write code
        System.out.println("Customer");
    }
}
