package com.personal.backoffice.user.associateclient.delete.process;

import com.personal.backoffice.user.associateclient.delete.process.rules.DeleteAssociatedUserClientRule;
import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteAssociatedUserClientProcessExecutor extends SupplierProcessExecutor<DeleteAssociatedUserClientProcess, AssociateUserClient> {

    public DeleteAssociatedUserClientProcessExecutor() {
        super(new DeleteAssociatedUserClientProcess(),
                DeleteAssociatedUserClientRule::new
        );
    }

    public static DeleteAssociatedUserClientProcessExecutor builder() {
        return new DeleteAssociatedUserClientProcessExecutor();
    }

}
