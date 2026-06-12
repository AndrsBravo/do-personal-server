package com.personal.business.payrolldeduction.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedPayrollDeduction;

public class PayrollDeduction extends SharedPayrollDeduction {

    private Business business;

    public PayrollDeduction() {
        super();
    }

    public PayrollDeduction(String id) {
        super(id);
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

}
