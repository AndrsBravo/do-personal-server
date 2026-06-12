package com.personal.business.hierarchydeduction.filter.process;

import com.personal.business.hierarchydeduction.entities.HierarchyDeduction;
import com.personal.business.hierarchydeduction.filter.inputs.FilterHierarchyDeductionInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterHierarchyDeductionProcess extends FunctionalProcess<FilterHierarchyDeductionInput, HierarchyDeduction> {

    public FilterHierarchyDeductionProcess() {
        super("filter_hierarchy_deduction_process");
    }

}
