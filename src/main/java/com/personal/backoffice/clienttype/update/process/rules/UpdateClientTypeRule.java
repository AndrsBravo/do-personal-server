package com.personal.backoffice.clienttype.update.process.rules;

import com.personal.backoffice.clienttype.factories.ClientTypeServiceFactory;
import com.personal.backoffice.clienttype.update.process.UpdateClientTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateClientTypeRule implements IProcessRule<UpdateClientTypeProcess> {

    @Override
    public void apply(UpdateClientTypeProcess process) {

        var pLogger = LogFactory.builder(UpdateClientTypeProcess.class, UpdateClientTypeRule.class);
        var createClientType = ClientTypeServiceFactory.EditClientType();
        var result = createClientType.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
