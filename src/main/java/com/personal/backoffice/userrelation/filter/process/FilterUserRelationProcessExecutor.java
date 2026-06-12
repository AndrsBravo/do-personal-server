package com.personal.backoffice.userrelation.filter.process;

import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.filter.inputs.FilterUserRelationInput;
import com.personal.backoffice.userrelation.filter.process.rules.FilterUserRelationRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterUserRelationProcessExecutor extends FunctionalProcessExecutor<FilterUserRelationProcess, FilterUserRelationInput, UserRelation> {

    public FilterUserRelationProcessExecutor() {
        super(new FilterUserRelationProcess(), FilterUserRelationRule::new);
    }

    public static FilterUserRelationProcessExecutor builder() {
        return new FilterUserRelationProcessExecutor();
    }

}
