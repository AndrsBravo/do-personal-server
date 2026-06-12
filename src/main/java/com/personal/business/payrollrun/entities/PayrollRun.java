package com.personal.business.payrollrun.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.business.country.entities.Country;
import com.personal.shared.core.entities.SharedPayrollRun;

public class PayrollRun extends SharedPayrollRun {

    private Business business;

    public PayrollRun() {
        super();
    }

    public PayrollRun(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
