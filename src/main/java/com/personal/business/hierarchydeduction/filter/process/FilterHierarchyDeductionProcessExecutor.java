package com.personal.business.hierarchydeduction.filter.process;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.filter.inputs.FilterHierarchyDeductionInput;
import com.personal.business.hierarchydeduction.filter.process.rules.FilterHierarchyDeductionRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterHierarchyDeductionProcessExecutor extends FunctionalProcessExecutor<FilterHierarchyDeductionProcess, FilterHierarchyDeductionInput, HierarchyDeduction> {

    public FilterHierarchyDeductionProcessExecutor() {
        super(new FilterHierarchyDeductionProcess(), FilterHierarchyDeductionRule::new);
    }

    public static FilterHierarchyDeductionProcessExecutor builder() {
        return new FilterHierarchyDeductionProcessExecutor();
    }

}
