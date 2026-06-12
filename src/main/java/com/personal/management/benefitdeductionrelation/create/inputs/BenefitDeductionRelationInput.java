package com.personal.management.benefitdeductionrelation.create.inputs;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.country.entities.Country;
import com.personal.management.shared.inputs.CountryInputBase;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedDeduction;

public class BenefitDeductionRelationInput extends CountryInputBase {

    private String benefitId;
    private String deductionId;

    public BenefitDeductionRelationInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public BenefitDeductionRelation getBenefitDeductionRelation() {
        var benefitDeductionRelation = this.id == null || this.id.isEmpty() ? new BenefitDeductionRelation() : new BenefitDeductionRelation(this.id);
        benefitDeductionRelation.setBenefit(new SharedBenefit(benefitId));
        benefitDeductionRelation.setDeduction(new SharedDeduction(deductionId));
        benefitDeductionRelation.setCountry(new Country(this.getCountryId()));
        benefitDeductionRelation.setCreatedBy(sessionUser);
        return benefitDeductionRelation;
    }
}
