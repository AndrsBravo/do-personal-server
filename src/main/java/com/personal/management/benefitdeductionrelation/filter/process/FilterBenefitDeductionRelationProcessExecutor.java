package com.personal.management.benefitdeductionrelation.filter.process;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.filter.inputs.FilterBenefitDeductionRelationInput;
import com.personal.management.benefitdeductionrelation.filter.process.rules.FilterBenefitDeductionRelationRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitDeductionRelationProcessExecutor extends FunctionalProcessExecutor<FilterBenefitDeductionRelationProcess, FilterBenefitDeductionRelationInput, BenefitDeductionRelation> {

    public FilterBenefitDeductionRelationProcessExecutor() {
        super(new FilterBenefitDeductionRelationProcess(), FilterBenefitDeductionRelationRule::new);
    }

    public static FilterBenefitDeductionRelationProcessExecutor builder() {
        return new FilterBenefitDeductionRelationProcessExecutor();
    }

}
