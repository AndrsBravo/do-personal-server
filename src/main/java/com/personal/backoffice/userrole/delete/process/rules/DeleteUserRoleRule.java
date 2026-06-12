package com.personal.backoffice.userrole.delete.process.rules;

import com.personal.backoffice.userrole.delete.process.DeleteUserRoleProcess;
import com.personal.backoffice.userrole.factories.UserRoleServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteUserRoleRule implements IProcessRule<DeleteUserRoleProcess> {

    @Override
    public void apply(DeleteUserRoleProcess process) {

        var pLogger = LogFactory.builder(DeleteUserRoleProcess.class, DeleteUserRoleRule.class);

        var query = process.Query();
        var userRole = process.getInitObject();

        query.Field("id", userRole.getId());
        query.Where().Equ("id");

        var createUserRole = UserRoleServiceFactory.DeleteUserRole();
        var result = createUserRole.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
