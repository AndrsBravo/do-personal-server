package com.personal.business.payrollrunbenefit.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedPayrollRunBenefit;

public class PayrollRunBenefit extends SharedPayrollRunBenefit {

    private Business business;

    public PayrollRunBenefit() {
        super();
    }

    public PayrollRunBenefit(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
