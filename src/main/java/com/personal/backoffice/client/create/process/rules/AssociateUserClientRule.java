package com.personal.backoffice.client.create.process.rules;

import com.personal.backoffice.client.create.process.CreateClientProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class AssociateUserClientRule implements IProcessRule<CreateClientProcess> {

    @Override
    public void apply(CreateClientProcess process) {

        var pLogger = LogFactory.builder(CreateClientProcess.class, AssociateUserClientRule.class);
        var associateClient = UserServiceFactory.AssociateUserClient();

        var client = process.getInitObject();

        var query = new Query();

        query.Field("client_id", client.getId());
        query.Field("users_id", client.getCreatedBy().getId());
        query.Field("created_at", client.getCreatedAt().toString());
        query.Field("updated_at", client.getUpdatedAt().toString());
        query.Field("created_by", client.getCreatedBy().getId());

        query.Field("user_role_id", process.Query().getParams().get("user_role_id"));
        query.Field("user_relation_id", process.Query().getParams().get("user_relation_id"));

        var result = associateClient.create(query);

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Asociar Cliente a Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Asociar Cliente a Usuario", "Cliente asociado a Usuario con éxito"));

    }

}
