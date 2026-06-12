package com.personal.backoffice.usertype.update.process.rules;

import com.personal.backoffice.usertype.update.process.UpdateUserTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsUserTypesRule implements IProcessRule<UpdateUserTypeProcess> {

    @Override
    public void apply(UpdateUserTypeProcess process) {

        var pLogger = LogFactory.builder(UpdateUserTypeProcess.class, UpdateFieldsParamsUserTypesRule.class);

        var query = process.Query();

        var userType = process.getInitObject();

        query.Field("id", userType.getId());
        query.Where().AndEqu("id");

        if (userType.getType() != null) {
            query.Set("ust_type", userType.getType());
        }
        if (userType.getDescription() != null) {
            query.Set("ust_description", userType.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
