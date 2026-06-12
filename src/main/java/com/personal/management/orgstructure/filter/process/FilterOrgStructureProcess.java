package com.personal.management.orgstructure.filter.process;

import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.management.orgstructure.filter.inputs.FilterOrgStructureInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOrgStructureProcess extends FunctionalProcess<FilterOrgStructureInput, OrgStructure> {

    public FilterOrgStructureProcess() {
        super("filter_org_structure");
    }

}
