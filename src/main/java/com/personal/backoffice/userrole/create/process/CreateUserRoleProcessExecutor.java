package com.personal.backoffice.userrole.create.process;

import com.personal.backoffice.userrole.create.process.rules.CreateUserRoleRule;
import com.personal.backoffice.userrole.create.process.rules.ValidateUserRoleRule;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateUserRoleProcessExecutor extends SupplierProcessExecutor<CreateUserRoleProcess, UserRole> {

    public CreateUserRoleProcessExecutor() {
        super(new CreateUserRoleProcess(),
                ValidateUserRoleRule::new,
                CreateUserRoleRule::new
        );
    }

    public static CreateUserRoleProcessExecutor builder() {
        return new CreateUserRoleProcessExecutor();
    }

}
