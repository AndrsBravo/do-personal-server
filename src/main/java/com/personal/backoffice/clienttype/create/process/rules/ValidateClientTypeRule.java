package com.personal.backoffice.clienttype.create.process.rules;

import com.personal.backoffice.clienttype.create.process.CreateClientTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateClientTypeRule implements IProcessRule<CreateClientTypeProcess> {

    @Override
    public void apply(CreateClientTypeProcess process) {

        var pLogger = LogFactory.builder(CreateClientTypeProcess.class, ValidateClientTypeRule.class);
        var query = process.Query();
        var clientType = process.getInitObject();
        query.Field("id", clientType.getId());
        query.Field("ct_type", clientType.getType());
        query.Field("ct_title", clientType.getTitle());
        query.Field("ct_description", clientType.getDescription());
        query.Field("ct_created_at", clientType.getCreatedAt().toString());
        query.Field("ct_updated_at", clientType.getUpdatedAt().toString());
        query.Field("ct_created_by", clientType.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
