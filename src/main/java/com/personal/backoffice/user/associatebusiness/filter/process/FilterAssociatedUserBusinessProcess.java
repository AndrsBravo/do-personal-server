package com.personal.backoffice.user.associatebusiness.filter.process;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.associatebusiness.filter.inputs.FilterAssociatedUserBusinessInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterAssociatedUserBusinessProcess extends FunctionalProcess<FilterAssociatedUserBusinessInput, AssociateUserBusiness> {

    public FilterAssociatedUserBusinessProcess() {
        super("filter_associate_user_client_process");
    }

}
