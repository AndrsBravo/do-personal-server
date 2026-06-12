package com.personal.backoffice.userrelation.update.process.rules;

import com.personal.backoffice.userrelation.factories.UserRelationServiceFactory;
import com.personal.backoffice.userrelation.update.process.UpdateUserRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateUserRelationRule implements IProcessRule<UpdateUserRelationProcess> {

    @Override
    public void apply(UpdateUserRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateUserRelationProcess.class, UpdateUserRelationRule.class);
        var createUserRelation = UserRelationServiceFactory.EditUserRelation();
        var result = createUserRelation.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
