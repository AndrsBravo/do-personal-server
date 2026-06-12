package com.personal.business.deductioncategory.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedDeductionCategory;

public class DeductionCategory extends SharedDeductionCategory {

    private Business business;

    public DeductionCategory() {
        super();
    }

    public DeductionCategory(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
