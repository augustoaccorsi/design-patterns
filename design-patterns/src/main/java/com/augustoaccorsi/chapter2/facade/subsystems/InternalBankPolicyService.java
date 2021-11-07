package com.augustoaccorsi.chapter2.facade.subsystems;

import com.augustoaccorsi.chapter2.facade.banksystems.Customer;
import javax.ejb.Stateless;

@Stateless
public class InternalBankPolicyService {
    public boolean checkCompliance(Customer customer) {
        // Check that customer conforms to bank policy on lending
        return true;
    }
}