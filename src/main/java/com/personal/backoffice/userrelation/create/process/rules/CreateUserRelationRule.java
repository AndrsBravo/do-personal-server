package com.personal.backoffice.userrelation.create.process.rules;

import com.personal.backoffice.userrelation.create.process.CreateUserRelationProcess;
import com.personal.backoffice.userrelation.factories.UserRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateUserRelationRule implements IProcessRule<CreateUserRelationProcess> {

    @Override
    public void apply(CreateUserRelationProcess process) {

        var pLogger = LogFactory.builder(CreateUserRelationProcess.class, CreateUserRelationRule.class);
        var createUserRelation = UserRelationServiceFactory.CreateUserRelation();
        var result = createUserRelation.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
