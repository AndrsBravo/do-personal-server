package com.personal.backoffice.userrelation.filter.process;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.filter.inputs.FilterUserRelationInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterUserRelationProcess extends FunctionalProcess<FilterUserRelationInput, UserRelation> {

    public FilterUserRelationProcess() {
        super("filter_user_relation");
    }

}
