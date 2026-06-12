package com.personal.backoffice.user.associateclient.update.process;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.backoffice.user.associateclient.update.process.rules.UpdateAssociatedUserClientRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateAssociatedUserClientProcessExecutor extends SupplierProcessExecutor<UpdateAssociatedUserClientProcess, AssociateUserClient> {

    public UpdateAssociatedUserClientProcessExecutor() {

        super(new UpdateAssociatedUserClientProcess(),
                UpdateAssociatedUserClientRule::new
        );
    }

    public static UpdateAssociatedUserClientProcessExecutor builder() {
        return new UpdateAssociatedUserClientProcessExecutor();
    }

}
