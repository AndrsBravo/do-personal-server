package com.personal.business.benefitdeductionrelation.filter.process;

import com.personal.business.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.business.benefitdeductionrelation.filter.inputs.FilterBenefitDeductionRelationInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterBenefitDeductionRelationProcess extends FunctionalProcess<FilterBenefitDeductionRelationInput, BenefitDeductionRelation> {

    public FilterBenefitDeductionRelationProcess() {
        super("filter_benefit_deduction_relation_");
    }

}
