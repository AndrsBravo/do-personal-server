package com.personal.backoffice.userrole.delete.process;

import com.personal.backoffice.userrole.delete.process.rules.DeleteUserRoleRule;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteUserRoleProcessExecutor extends SupplierProcessExecutor<DeleteUserRoleProcess, UserRole> {

    public DeleteUserRoleProcessExecutor() {
        super(new DeleteUserRoleProcess(),
                DeleteUserRoleRule::new
        );
    }

    public static DeleteUserRoleProcessExecutor builder() {
        return new DeleteUserRoleProcessExecutor();
    }

}
