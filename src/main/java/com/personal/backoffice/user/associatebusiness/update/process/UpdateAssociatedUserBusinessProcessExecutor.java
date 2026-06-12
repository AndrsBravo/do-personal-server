package com.personal.backoffice.user.associatebusiness.update.process;

import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.associatebusiness.update.process.rules.UpdateAssociatedUserBusinessRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateAssociatedUserBusinessProcessExecutor extends SupplierProcessExecutor<UpdateAssociatedUserBusinessProcess, AssociateUserBusiness> {

    public UpdateAssociatedUserBusinessProcessExecutor() {

        super(new UpdateAssociatedUserBusinessProcess(),
                UpdateAssociatedUserBusinessRule::new
        );
    }

    public static UpdateAssociatedUserBusinessProcessExecutor builder() {
        return new UpdateAssociatedUserBusinessProcessExecutor();
    }

}
