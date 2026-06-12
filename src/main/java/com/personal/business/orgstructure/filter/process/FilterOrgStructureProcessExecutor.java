package com.personal.business.orgstructure.filter.process;

import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.filter.inputs.FilterOrgStructureInput;
import com.personal.business.orgstructure.filter.process.rules.FilterOrgStructureRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterOrgStructureProcessExecutor extends FunctionalProcessExecutor<FilterOrgStructureProcess, FilterOrgStructureInput, OrgStructure> {

    public FilterOrgStructureProcessExecutor() {
        super(new FilterOrgStructureProcess(), FilterOrgStructureRule::new);
    }

    public static FilterOrgStructureProcessExecutor builder() {
        return new FilterOrgStructureProcessExecutor();
    }

}
