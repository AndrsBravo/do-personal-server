package com.personal.backoffice.userrole.update.process.rules;

import com.personal.backoffice.userrole.factories.UserRoleServiceFactory;
import com.personal.backoffice.userrole.update.process.UpdateUserRoleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateUserRoleRule implements IProcessRule<UpdateUserRoleProcess> {

    @Override
    public void apply(UpdateUserRoleProcess process) {

        var pLogger = LogFactory.builder(UpdateUserRoleProcess.class, UpdateUserRoleRule.class);
        var createUserRole = UserRoleServiceFactory.EditUserRole();
        var result = createUserRole.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
