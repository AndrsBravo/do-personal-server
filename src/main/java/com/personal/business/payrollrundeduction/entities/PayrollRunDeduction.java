package com.personal.business.payrollrundeduction.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedPayrollRunDeduction;

public class PayrollRunDeduction extends SharedPayrollRunDeduction {

    private Business business;

    public PayrollRunDeduction() {
        super();
    }

    public PayrollRunDeduction(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
