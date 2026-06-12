package com.personal.backoffice.user.associatebusiness.add.process;

import com.personal.backoffice.user.associatebusiness.add.process.rules.AssociateUserBusinessRule;
import com.personal.backoffice.user.associatebusiness.add.process.rules.ValidateAssociateUserBusinessRule;
import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.shared.process.SupplierProcessExecutor;

public class AssociateUserBusinessProcessExecutor extends SupplierProcessExecutor<AssociateUserBusinessProcess, AssociateUserBusiness> {

    public AssociateUserBusinessProcessExecutor() {
        super(new AssociateUserBusinessProcess(),
                ValidateAssociateUserBusinessRule::new,
                AssociateUserBusinessRule::new
        );
    }

    public static AssociateUserBusinessProcessExecutor builder() {
        return new AssociateUserBusinessProcessExecutor();
    }

}
