package com.personal.business.deduction.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedDeduction;

public class Deduction extends SharedDeduction {

    private Business business;

    public Deduction() {
        super();
    }

    public Deduction(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
