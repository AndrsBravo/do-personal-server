package com.personal.backoffice.user.associateclient.filter.process;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.associateclient.filter.inputs.FilterAssociatedUserClientInput;
import com.personal.backoffice.user.associateclient.filter.process.rules.FilterAssociatedUserClientRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterAssociatedUserClientProcessExecutor extends FunctionalProcessExecutor<FilterAssociatedUserClientProcess, FilterAssociatedUserClientInput, AssociateUserClient> {

    public FilterAssociatedUserClientProcessExecutor() {
        super(new FilterAssociatedUserClientProcess(),
                FilterAssociatedUserClientRule::new
        );
    }

    public static FilterAssociatedUserClientProcessExecutor builder() {
        return new FilterAssociatedUserClientProcessExecutor();
    }

}
