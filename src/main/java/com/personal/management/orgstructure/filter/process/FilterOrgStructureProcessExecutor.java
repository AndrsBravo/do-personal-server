package com.personal.management.orgstructure.filter.process;

import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.management.orgstructure.filter.inputs.FilterOrgStructureInput;
import com.personal.management.orgstructure.filter.process.rules.FilterOrgStructureRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterOrgStructureProcessExecutor extends FunctionalProcessExecutor<FilterOrgStructureProcess, FilterOrgStructureInput, OrgStructure> {

    public FilterOrgStructureProcessExecutor() {
        super(new FilterOrgStructureProcess(), FilterOrgStructureRule::new);
    }

    public static FilterOrgStructureProcessExecutor builder() {
        return new FilterOrgStructureProcessExecutor();
    }

}
