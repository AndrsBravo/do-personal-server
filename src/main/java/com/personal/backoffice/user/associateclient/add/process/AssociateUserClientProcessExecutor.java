package com.personal.backoffice.user.associateclient.add.process;

import com.personal.backoffice.user.associateclient.add.process.rules.AssociateUserClientRule;
import com.personal.backoffice.user.associateclient.add.process.rules.ValidateAssociateUserClientRule;
import com.personal.backoffice.user.associateclient.entities.AssociateUserClient;
import com.personal.shared.process.SupplierProcessExecutor;

public class AssociateUserClientProcessExecutor extends SupplierProcessExecutor<AssociateUserClientProcess, AssociateUserClient> {

    public AssociateUserClientProcessExecutor() {
        super(new AssociateUserClientProcess(),
                ValidateAssociateUserClientRule::new,
                AssociateUserClientRule::new
        );
    }

    public static AssociateUserClientProcessExecutor builder() {
        return new AssociateUserClientProcessExecutor();
    }

}
