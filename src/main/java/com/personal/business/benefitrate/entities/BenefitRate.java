package com.personal.business.benefitrate.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedBenefitRate;

public class BenefitRate extends SharedBenefitRate {

    private Business business;

    public BenefitRate() {
        super();
    }

    public BenefitRate(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
