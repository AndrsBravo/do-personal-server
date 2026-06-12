package com.personal.backoffice.userrole.delete.process;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.process.SupplierProcess;

public class DeleteUserRoleProcess extends SupplierProcess<UserRole> {

    public DeleteUserRoleProcess() {
        super("delete_user_role_process");
    }

}
