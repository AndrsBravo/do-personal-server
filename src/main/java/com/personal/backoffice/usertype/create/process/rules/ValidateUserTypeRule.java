package com.personal.backoffice.usertype.create.process.rules;

import com.personal.backoffice.usertype.create.process.CreateUserTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateUserTypeRule implements IProcessRule<CreateUserTypeProcess> {

    @Override
    public void apply(CreateUserTypeProcess process) {

        var pLogger = LogFactory.builder(CreateUserTypeProcess.class, ValidateUserTypeRule.class);
        var query = process.Query();
        var userType = process.getInitObject();
        query.Field("id", userType.getId());
        query.Field("ust_type", userType.getType());
        query.Field("ust_description", userType.getDescription());
        query.Field("ust_created_at", userType.getCreatedAt().toString());
        query.Field("ust_updated_at", userType.getUpdatedAt().toString());
        query.Field("ust_created_by", userType.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
