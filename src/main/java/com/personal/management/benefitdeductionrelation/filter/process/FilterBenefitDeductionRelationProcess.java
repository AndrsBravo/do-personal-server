package com.personal.management.benefitdeductionrelation.filter.process;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.filter.inputs.FilterBenefitDeductionRelationInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitDeductionRelationProcess extends FunctionalProcess<FilterBenefitDeductionRelationInput, BenefitDeductionRelation> {

    public FilterBenefitDeductionRelationProcess() {
        super("filter_benefit_deduction_relation_");
    }

}
