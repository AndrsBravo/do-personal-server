package com.personal.business.orgstructure.filter.process;

import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.filter.inputs.FilterOrgStructureInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOrgStructureProcess extends FunctionalProcess<FilterOrgStructureInput, OrgStructure> {

    public FilterOrgStructureProcess() {
        super("filter_org_structure");
    }

}
