package com.personal.backoffice.client.create.process.rules;

import com.personal.backoffice.client.factories.ClientServiceFactory;
import com.personal.backoffice.client.create.process.CreateClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateClientRule implements IProcessRule<CreateClientProcess> {

    @Override
    public void apply(CreateClientProcess process) {

        var pLogger = LogFactory.builder(CreateClientProcess.class, CreateClientRule.class);
        var createClient = ClientServiceFactory.CreateClient();
        var result = createClient.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
