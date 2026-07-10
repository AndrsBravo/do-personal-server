package com.personal.management.benefitdeductionrelation.entities;

import com.personal.shared.core.entities.SharedBenefitDeductionRelation;
import com.personal.shared.core.entities.SharedCountry;

public class BenefitDeductionRelation extends SharedBenefitDeductionRelation {

    private SharedCountry country;

    public BenefitDeductionRelation() {
        super();
    }

    public BenefitDeductionRelation(String id) {
        super(id);
    }

    public SharedCountry getCountry() {
        return country;
    }

    public void setCountry(SharedCountry country) {
        this.country = country;
    }

}
