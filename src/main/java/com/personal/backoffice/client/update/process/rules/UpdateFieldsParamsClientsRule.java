package com.personal.backoffice.client.update.process.rules;

import com.personal.backoffice.client.update.process.UpdateClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsClientsRule implements IProcessRule<UpdateClientProcess> {

    @Override
    public void apply(UpdateClientProcess process) {

        var pLogger = LogFactory.builder(UpdateClientProcess.class, UpdateFieldsParamsClientsRule.class);

        var query = process.Query();

        var client = process.getInitObject();

        query.Field("id", client.getId());
        query.Where().AndEqu("id");

        if (client.getClientType() != null) {
            query.Set("c_types_id", client.getClientType().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
