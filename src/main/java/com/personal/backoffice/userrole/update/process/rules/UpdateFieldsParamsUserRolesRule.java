package com.personal.backoffice.userrole.update.process.rules;

import com.personal.backoffice.userrole.update.process.UpdateUserRoleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsUserRolesRule implements IProcessRule<UpdateUserRoleProcess> {

    @Override
    public void apply(UpdateUserRoleProcess process) {

        var pLogger = LogFactory.builder(UpdateUserRoleProcess.class, UpdateFieldsParamsUserRolesRule.class);

        var query = process.Query();

        var userRole = process.getInitObject();

        query.Field("id", userRole.getId());
        query.Where().AndEqu("id");

        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
