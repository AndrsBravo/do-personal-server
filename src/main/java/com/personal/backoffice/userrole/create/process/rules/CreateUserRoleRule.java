package com.personal.backoffice.userrole.create.process.rules;

import com.personal.backoffice.userrole.create.process.CreateUserRoleProcess;
import com.personal.backoffice.userrole.factories.UserRoleServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateUserRoleRule implements IProcessRule<CreateUserRoleProcess> {

    @Override
    public void apply(CreateUserRoleProcess process) {

        var pLogger = LogFactory.builder(CreateUserRoleProcess.class, CreateUserRoleRule.class);
        var createUserRole = UserRoleServiceFactory.CreateUserRole();
        var result = createUserRole.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
