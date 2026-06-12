package com.personal.business.orghierarchy.filter.process;

import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orghierarchy.filter.inputs.FilterOrgHierarchyInput;
import com.personal.business.orghierarchy.filter.process.rules.FilterOrgHierarchyRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterOrgHierarchyProcessExecutor extends FunctionalProcessExecutor<FilterOrgHierarchyProcess, FilterOrgHierarchyInput, OrgHierarchy> {

    public FilterOrgHierarchyProcessExecutor() {
        super(new FilterOrgHierarchyProcess(), FilterOrgHierarchyRule::new);
    }

    public static FilterOrgHierarchyProcessExecutor builder() {
        return new FilterOrgHierarchyProcessExecutor();
    }

}
