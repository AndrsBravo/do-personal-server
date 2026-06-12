package com.personal.business.benefit.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedBenefit;

public class Benefit extends SharedBenefit {

    private Business business;

    public Benefit() {
        super();
    }

    public Benefit(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
