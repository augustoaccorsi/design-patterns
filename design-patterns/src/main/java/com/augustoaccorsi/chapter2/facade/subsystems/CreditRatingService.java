package com.augustoaccorsi.chapter2.facade.subsystems;

import com.augustoaccorsi.chapter2.facade.banksystems.Customer;
import javax.ejb.Stateless;

@Stateless
public class CreditRatingService {
    public boolean checkCustomerRating(Customer customer) {
        Integer rating = 900; // Connect to external credit reference agency
        return rating > 700;
    }
}