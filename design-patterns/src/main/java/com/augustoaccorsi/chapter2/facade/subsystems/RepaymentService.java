package com.augustoaccorsi.chapter2.facade.subsystems;

import com.augustoaccorsi.chapter2.facade.banksystems.Customer;
import javax.ejb.Stateless;

@Stateless
public class RepaymentService {
    public void setUpPaymentSchedule(Customer customer, Double principle, Integer months) {
        // set up monthly automatic payment from customer account to bank
    }
}