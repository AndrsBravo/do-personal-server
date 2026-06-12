package com.personal.backoffice.clienttype.create.process.rules;

import com.personal.backoffice.clienttype.create.process.CreateClientTypeProcess;
import com.personal.backoffice.clienttype.factories.ClientTypeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateClientTypeRule implements IProcessRule<CreateClientTypeProcess> {

    @Override
    public void apply(CreateClientTypeProcess process) {

        var pLogger = LogFactory.builder(CreateClientTypeProcess.class, CreateClientTypeRule.class);
        var createClientType = ClientTypeServiceFactory.CreateClientType();
        var result = createClientType.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
