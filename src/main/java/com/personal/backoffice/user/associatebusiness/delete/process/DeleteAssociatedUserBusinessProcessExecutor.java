package com.personal.backoffice.user.associatebusiness.delete.process;

import com.personal.backoffice.user.associatebusiness.delete.process.rules.DeleteAssociatedUserBusinessRule;
import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteAssociatedUserBusinessProcessExecutor extends SupplierProcessExecutor<DeleteAssociatedUserBusinessProcess, AssociateUserBusiness> {

    public DeleteAssociatedUserBusinessProcessExecutor() {
        super(new DeleteAssociatedUserBusinessProcess(),
                DeleteAssociatedUserBusinessRule::new
        );
    }

    public static DeleteAssociatedUserBusinessProcessExecutor builder() {
        return new DeleteAssociatedUserBusinessProcessExecutor();
    }

}
