package com.personal.business.benefitcategory.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedBenefitCategory;

public class BenefitCategory extends SharedBenefitCategory {

    private Business business;

    public BenefitCategory() {
        super();
    }

    public BenefitCategory(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
