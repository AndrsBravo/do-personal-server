package com.personal.backoffice.clienttype.update.process.rules;

import com.personal.backoffice.clienttype.update.process.UpdateClientTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsClientTypesRule implements IProcessRule<UpdateClientTypeProcess> {

    @Override
    public void apply(UpdateClientTypeProcess process) {

        var pLogger = LogFactory.builder(UpdateClientTypeProcess.class, UpdateFieldsParamsClientTypesRule.class);

        var query = process.Query();

        var clientType = process.getInitObject();

        query.Field("id", clientType.getId());
        query.Where().Equ("id");

        if (clientType.getType() != null) {
            query.Set("ct_type", clientType.getType());
        }
        if (clientType.getDescription() != null) {
            query.Set("ct_description", clientType.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
