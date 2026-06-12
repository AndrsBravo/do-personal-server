package com.personal.business.benefitdeductionrelation.filter.process;

import com.personal.business.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.business.benefitdeductionrelation.filter.inputs.FilterBenefitDeductionRelationInput;
import com.personal.business.benefitdeductionrelation.filter.process.rules.FilterBenefitDeductionRelationRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterBenefitDeductionRelationProcessExecutor extends FunctionalProcessExecutor<FilterBenefitDeductionRelationProcess, FilterBenefitDeductionRelationInput, BenefitDeductionRelation> {

    public FilterBenefitDeductionRelationProcessExecutor() {
        super(new FilterBenefitDeductionRelationProcess(), FilterBenefitDeductionRelationRule::new);
    }

    public static FilterBenefitDeductionRelationProcessExecutor builder() {
        return new FilterBenefitDeductionRelationProcessExecutor();
    }

}
