package com.personal.backoffice.userrole.create.process;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.process.SupplierProcess;

public class CreateUserRoleProcess extends SupplierProcess<UserRole> {

    public CreateUserRoleProcess() {
        super("create_user_role_process");
    }

}
