package com.personal.backoffice.business.process.update.rules;

import com.personal.backoffice.business.process.update.UpdateBusinessProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsBusinessRule implements IProcessRule<UpdateBusinessProcess> {

    @Override
    public void apply(UpdateBusinessProcess process) {

        var pLogger = LogFactory.builder(UpdateBusinessProcess.class, UpdateFieldsParamsBusinessRule.class);

        var query = process.Query();

        var business = process.getInitObject();

        query.Field("id", business.getId());
        query.Where().AndEqu("id");

        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
