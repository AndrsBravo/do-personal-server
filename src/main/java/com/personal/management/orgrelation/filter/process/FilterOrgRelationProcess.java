package com.personal.management.orgrelation.filter.process;

import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.management.orgrelation.filter.inputs.FilterOrgRelationInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOrgRelationProcess extends FunctionalProcess<FilterOrgRelationInput, OrgRelation> {

    public FilterOrgRelationProcess() {
        super("filter_org_relation_");
    }

}
