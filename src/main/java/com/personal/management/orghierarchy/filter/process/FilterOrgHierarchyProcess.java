package com.personal.management.orghierarchy.filter.process;

import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.orghierarchy.filter.inputs.FilterOrgHierarchyInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOrgHierarchyProcess extends FunctionalProcess<FilterOrgHierarchyInput, OrgHierarchy> {

    public FilterOrgHierarchyProcess() {
        super("filter_org_hierarchy_");
    }

}
