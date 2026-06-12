package com.personal.business.orgrelation.filter.process;

import com.personal.business.orgrelation.entities.OrgRelation;
import com.personal.business.orgrelation.filter.inputs.FilterOrgRelationInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterOrgRelationProcess extends FunctionalProcess<FilterOrgRelationInput, OrgRelation> {

    public FilterOrgRelationProcess() {
        super("filter_org_relation_");
    }

}
