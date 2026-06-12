package com.personal.backoffice.user.associateclient.delete.process;

import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.shared.process.SupplierProcess;

public class DeleteAssociatedUserClientProcess extends SupplierProcess<AssociateUserClient> {

    public DeleteAssociatedUserClientProcess() {
        super("delete_associated_user_client_process");
    }

}
