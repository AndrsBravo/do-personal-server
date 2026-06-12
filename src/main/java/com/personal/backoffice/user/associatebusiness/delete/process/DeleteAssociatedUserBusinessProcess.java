package com.personal.backoffice.user.associatebusiness.delete.process;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.shared.process.SupplierProcess;

public class DeleteAssociatedUserBusinessProcess extends SupplierProcess<AssociateUserBusiness> {

    public DeleteAssociatedUserBusinessProcess() {
        super("delete_associated_user_client_process");
    }

}
