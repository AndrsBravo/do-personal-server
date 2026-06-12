package com.personal.business.payroll.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedPayroll;

public class Payroll extends SharedPayroll {

    private Business business;

    public Payroll() {
        super();
    }

    public Payroll(String id) {
        super(id);
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Business getBusiness() {
        return business;
    }

}
