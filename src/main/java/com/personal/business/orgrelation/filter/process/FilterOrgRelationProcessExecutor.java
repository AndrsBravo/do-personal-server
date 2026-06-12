package com.personal.business.orgrelation.filter.process;

import com.personal.business.orgrelation.entities.OrgRelation;
import com.personal.business.orgrelation.filter.inputs.FilterOrgRelationInput;
import com.personal.business.orgrelation.filter.process.rules.FilterOrgRelationRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterOrgRelationProcessExecutor extends FunctionalProcessExecutor<FilterOrgRelationProcess, FilterOrgRelationInput, OrgRelation> {

    public FilterOrgRelationProcessExecutor() {
        super(new FilterOrgRelationProcess(), FilterOrgRelationRule::new);
    }

    public static FilterOrgRelationProcessExecutor builder() {
        return new FilterOrgRelationProcessExecutor();
    }

}
