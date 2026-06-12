package com.personal.business.deductionrate.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedDeductionRate;

public class DeductionRate extends SharedDeductionRate {

    private Business business;

    public DeductionRate() {
        super();
    }

    public DeductionRate(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
