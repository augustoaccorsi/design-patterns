package com.augustoaccorsi.chapter2.facade.subsystems;

import com.augustoaccorsi.chapter2.facade.banksystems.Customer;
import javax.ejb.Stateless;

@Stateless
public class TransferService {
    public void makeTransfer(Double principle, Customer customer) {
        // Transfer principle to customer bank account
    }
}