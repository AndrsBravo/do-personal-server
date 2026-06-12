package com.personal.backoffice.user.associatebusiness.add.process.rules;

import com.personal.backoffice.user.associatebusiness.add.process.AssociateUserBusinessProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateAssociateUserBusinessRule implements IProcessRule<AssociateUserBusinessProcess> {

    @Override
    public void apply(AssociateUserBusinessProcess process) {

        var pLogger = LogFactory.builder(AssociateUserBusinessProcess.class, ValidateAssociateUserBusinessRule.class);
        var query = process.Query();
        var associateUserToClient = process.getInitObject();
        query.Field("id", associateUserToClient.getId());
        query.Field("business_id", associateUserToClient.getBusiness().getId());
        query.Field("users_id", associateUserToClient.getUser().getId());
        query.Field("user_role_id", associateUserToClient.getUserRole().getId());
        query.Field("user_relation_id", associateUserToClient.getUserRelation().getId());
        query.Field("created_at", associateUserToClient.getCreatedAt().toString());
        query.Field("updated_at", associateUserToClient.getUpdatedAt().toString());
        query.Field("created_by", associateUserToClient.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
