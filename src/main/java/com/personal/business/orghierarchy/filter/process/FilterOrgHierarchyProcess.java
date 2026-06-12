package com.personal.business.orghierarchy.filter.process;

import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orghierarchy.filter.inputs.FilterOrgHierarchyInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOrgHierarchyProcess extends FunctionalProcess<FilterOrgHierarchyInput, OrgHierarchy> {

    public FilterOrgHierarchyProcess() {
        super("filter_org_hierarchy_");
    }

}
