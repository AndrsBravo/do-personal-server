package com.personal.business.hierarchybenefit.filter.process;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.filter.inputs.FilterHierarchyBenefitInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterHierarchyBenefitProcess extends FunctionalProcess<FilterHierarchyBenefitInput, HierarchyBenefit> {

    public FilterHierarchyBenefitProcess() {
        super("filter_hierarchy_benefit_process");
    }

}
