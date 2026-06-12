package com.personal.backoffice.client.update.process.rules;

import com.personal.backoffice.client.factories.ClientServiceFactory;
import com.personal.backoffice.client.update.process.UpdateClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateClientRule implements IProcessRule<UpdateClientProcess> {

    @Override
    public void apply(UpdateClientProcess process) {

        var pLogger = LogFactory.builder(UpdateClientProcess.class, UpdateClientRule.class);
        var createClient = ClientServiceFactory.EditClient();
        var result = createClient.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
