package com.personal.backoffice.userrole.update.process;

import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.backoffice.userrole.update.process.rules.UpdateFieldsParamsUserRolesRule;
import com.personal.backoffice.userrole.update.process.rules.UpdateUserRoleRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateUserRoleProcessExecutor extends SupplierProcessExecutor<UpdateUserRoleProcess, UserRole> {

    public UpdateUserRoleProcessExecutor() {
        super(new UpdateUserRoleProcess(),
                UpdateFieldsParamsUserRolesRule::new,
                UpdateUserRoleRule::new
        );
    }

    public static UpdateUserRoleProcessExecutor builder() {
        return new UpdateUserRoleProcessExecutor();
    }

}
