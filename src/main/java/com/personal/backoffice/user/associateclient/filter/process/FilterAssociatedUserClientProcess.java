package com.personal.backoffice.user.associateclient.filter.process;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.associateclient.filter.inputs.FilterAssociatedUserClientInput;
import com.personal.shared.process.FunctionalProcess;

public class FilterAssociatedUserClientProcess extends FunctionalProcess<FilterAssociatedUserClientInput, AssociateUserClient> {

    public FilterAssociatedUserClientProcess() {
        super("filter_associate_user_client_process");
    }

}
