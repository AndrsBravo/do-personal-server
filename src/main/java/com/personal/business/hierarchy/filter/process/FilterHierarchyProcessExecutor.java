package com.personal.business.hierarchy.filter.process;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.filter.inputs.FilterHierarchyInput;
import com.personal.business.hierarchy.filter.process.rules.FilterHierarchyRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterHierarchyProcessExecutor extends FunctionalProcessExecutor<FilterHierarchyProcess, FilterHierarchyInput, Hierarchy> {

    public FilterHierarchyProcessExecutor() {
        super(new FilterHierarchyProcess(), FilterHierarchyRule::new);
    }

    public static FilterHierarchyProcessExecutor builder() {
        return new FilterHierarchyProcessExecutor();
    }

}
