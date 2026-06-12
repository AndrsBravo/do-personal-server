package com.personal.backoffice.usertype.create.process.rules;

import com.personal.backoffice.usertype.create.process.CreateUserTypeProcess;
import com.personal.backoffice.usertype.factories.UserTypeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateUserTypeRule implements IProcessRule<CreateUserTypeProcess> {

    @Override
    public void apply(CreateUserTypeProcess process) {

        var pLogger = LogFactory.builder(CreateUserTypeProcess.class, CreateUserTypeRule.class);
        var createUserType = UserTypeServiceFactory.CreateUserType();
        var result = createUserType.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
