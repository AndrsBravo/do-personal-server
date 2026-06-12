package com.personal.management.benefitdeductionrelation.entities;

import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedBenefitDeductionRelation;

public class BenefitDeductionRelation extends SharedBenefitDeductionRelation {

    private Country country;

    public BenefitDeductionRelation() {
        super();
    }

    public BenefitDeductionRelation(String id) {
        super(id);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
