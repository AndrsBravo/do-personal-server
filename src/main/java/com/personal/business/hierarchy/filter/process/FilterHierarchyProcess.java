package com.personal.business.hierarchy.filter.process;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.filter.inputs.FilterHierarchyInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterHierarchyProcess extends FunctionalProcess<FilterHierarchyInput, Hierarchy> {

    public FilterHierarchyProcess() {
        super("filter_hierarchy_");
    }

}
