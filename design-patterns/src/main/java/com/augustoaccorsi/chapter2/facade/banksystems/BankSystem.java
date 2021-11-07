package com.augustoaccorsi.chapter2.facade.banksystems;

import com.augustoaccorsi.chapter2.facade.subsystems.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BankSystem {
    @EJB
    private CreditRatingService creditRatingService;
    @EJB
    private InternalBankPolicyService internalBankPolicyService;
    @EJB
    private RepaymentPayabilityService repaymentPayabilityService;
    @EJB
    private RepaymentService repaymentService;
    @EJB
    private TransferService transferService;

    public boolean processLoanApplication(Customer customer, Double principle, Double income, Integer months) {

        if (!creditRatingService.checkCustomerRating(customer))
            return false;

        if (!repaymentPayabilityService.calculatePayability(principle, income, months))
            return false;

        if (!internalBankPolicyService.checkCompliance(customer))
            return false;

        // Application successful, so transfer principle and set up repayment schedule
        transferService.makeTransfer(principle, customer);
        repaymentService.setUpPaymentSchedule(customer, principle, months);

        return true;
    }

}