package com.personal.business.hierarchybenefit.filter.process;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.filter.inputs.FilterHierarchyBenefitInput;
import com.personal.business.hierarchybenefit.filter.process.rules.FilterHierarchyBenefitRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterHierarchyBenefitProcessExecutor extends FunctionalProcessExecutor<FilterHierarchyBenefitProcess, FilterHierarchyBenefitInput, HierarchyBenefit> {

    public FilterHierarchyBenefitProcessExecutor() {
        super(new FilterHierarchyBenefitProcess(), FilterHierarchyBenefitRule::new);
    }

    public static FilterHierarchyBenefitProcessExecutor builder() {
        return new FilterHierarchyBenefitProcessExecutor();
    }

}
