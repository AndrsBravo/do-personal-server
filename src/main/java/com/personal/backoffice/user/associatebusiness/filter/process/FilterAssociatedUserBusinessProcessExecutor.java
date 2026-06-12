package com.personal.backoffice.user.associatebusiness.filter.process;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.associatebusiness.filter.inputs.FilterAssociatedUserBusinessInput;
import com.personal.backoffice.user.associatebusiness.filter.process.rules.FilterAssociatedUserBusinessRule;
import com.personal.shared.process.FunctionalProcessExecutor;

public class FilterAssociatedUserBusinessProcessExecutor extends FunctionalProcessExecutor<FilterAssociatedUserBusinessProcess, FilterAssociatedUserBusinessInput, AssociateUserBusiness> {

    public FilterAssociatedUserBusinessProcessExecutor() {
        super(new FilterAssociatedUserBusinessProcess(),
                FilterAssociatedUserBusinessRule::new
        );
    }

    public static FilterAssociatedUserBusinessProcessExecutor builder() {
        return new FilterAssociatedUserBusinessProcessExecutor();
    }

}
