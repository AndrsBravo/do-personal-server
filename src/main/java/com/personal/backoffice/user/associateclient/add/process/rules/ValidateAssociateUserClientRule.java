package com.personal.backoffice.user.associateclient.add.process.rules;

import com.personal.backoffice.user.associateclient.add.process.AssociateUserClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateAssociateUserClientRule implements IProcessRule<AssociateUserClientProcess> {

    @Override
    public void apply(AssociateUserClientProcess process) {

        var pLogger = LogFactory.builder(AssociateUserClientProcess.class, ValidateAssociateUserClientRule.class);
        var query = process.Query();
        var associateUserToClient = process.getInitObject();
        query.Field("id", associateUserToClient.getId());
        query.Field("client_id", associateUserToClient.getClient().getId());
        query.Field("users_id", associateUserToClient.getUser().getId());
        query.Field("user_role_id", associateUserToClient.getUserRole().getId());
        query.Field("user_relation_id", associateUserToClient.getUserRelation().getId());
        query.Field("created_at", associateUserToClient.getCreatedAt().toString());
        query.Field("updated_at", associateUserToClient.getUpdatedAt().toString());
        query.Field("created_by", associateUserToClient.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
