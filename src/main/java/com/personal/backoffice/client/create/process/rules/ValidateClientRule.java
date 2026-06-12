package com.personal.backoffice.client.create.process.rules;

import com.personal.backoffice.client.create.process.CreateClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateClientRule implements IProcessRule<CreateClientProcess> {

    @Override
    public void apply(CreateClientProcess process) {

        var pLogger = LogFactory.builder(CreateClientProcess.class, ValidateClientRule.class);
        var query = process.Query();
        var client = process.getInitObject();
        query.Field("id", client.getId());
        query.Field("c_types_id", client.getClientType().getId());
        query.Field("country_id", client.getCountry().getId());
        query.Field("c_created_at", client.getCreatedAt().toString());
        query.Field("c_updated_at", client.getUpdatedAt().toString());
        query.Field("c_created_by", client.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
