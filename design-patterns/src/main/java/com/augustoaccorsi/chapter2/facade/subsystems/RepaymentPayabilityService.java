package com.augustoaccorsi.chapter2.facade.subsystems;

import javax.ejb.Stateless;

@Stateless
public class RepaymentPayabilityService {
    public boolean calculatePayability(Double principle, Double income, Integer months) {
        // Calculate payability based on bank policy
        // If monthly repayment is less than 50% of monthly income then repayment in affordable
        return (income / 12) * 0.5 > principle / months;
    }
}