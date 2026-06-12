package com.personal.business.payrollbenefit.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedPayrollBenefit;

public class PayrollBenefit extends SharedPayrollBenefit {

    private Business business;

    public PayrollBenefit() {
        super();
    }

    public PayrollBenefit(String id) {
        super(id);
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

}
