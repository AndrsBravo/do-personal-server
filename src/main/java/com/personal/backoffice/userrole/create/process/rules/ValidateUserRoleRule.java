package com.personal.backoffice.userrole.create.process.rules;

import com.personal.backoffice.userrole.create.process.CreateUserRoleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateUserRoleRule implements IProcessRule<CreateUserRoleProcess> {

    @Override
    public void apply(CreateUserRoleProcess process) {

        var pLogger = LogFactory.builder(CreateUserRoleProcess.class, ValidateUserRoleRule.class);
        var query = process.Query();
        var userRole = process.getInitObject();
        query.Field("id", userRole.getId());
        query.Field("url_role", userRole.getRole());
        query.Field("url_title", userRole.getTitle());
        query.Field("url_description", userRole.getDescription());
        query.Field("url_created_at", userRole.getCreatedAt().toString());
        query.Field("url_updated_at", userRole.getUpdatedAt().toString());
        query.Field("url_created_by", userRole.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
