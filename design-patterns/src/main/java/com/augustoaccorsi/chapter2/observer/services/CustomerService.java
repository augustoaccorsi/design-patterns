package com.augustoaccorsi.chapter2.observer.services;

import com.augustoaccorsi.chapter2.observer.Customer;
import com.augustoaccorsi.chapter2.observer.CustomerEvent;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class CustomerService {
    public void createCustomer(@Observes @Priority(10) @CustomerEvent(CustomerEvent.Type.ADD) Customer customer){
        // write code
        System.out.println("Customer");
    }

    public void removeCustomer(@Observes @CustomerEvent(CustomerEvent.Type.REMOVE) Customer customer){
        //write code
    }
}
