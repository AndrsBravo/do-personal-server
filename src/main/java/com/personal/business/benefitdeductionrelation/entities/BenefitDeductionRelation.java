package com.personal.business.benefitdeductionrelation.entities;

import com.personal.backoffice.business.entities.Business;
import com.personal.shared.core.entities.SharedBenefitDeductionRelation;

public class BenefitDeductionRelation extends SharedBenefitDeductionRelation {

    private Business business;

    public BenefitDeductionRelation() {
        super();
    }

    public BenefitDeductionRelation(String id) {
        super(id);
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

}
