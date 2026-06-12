package com.personal.shared.core.entities;

import com.personal.shared.entities.ShortEntity;

public class SharedBenefitDeductionRelation extends ShortEntity {

    private SharedBenefit benefit;
    private SharedDeduction deduction;

    public SharedBenefitDeductionRelation() {
        super();
    }

    public SharedBenefitDeductionRelation(String id) {
        super(id);
    }

    public SharedBenefit getBenefit() {
        return benefit;
    }

    public void setBenefit(SharedBenefit benefit) {
        this.benefit = benefit;
    }

    public SharedDeduction getDeduction() {
        return deduction;
    }

    public void setDeduction(SharedDeduction deduction) {
        this.deduction = deduction;
    }

}
