package com.personal.backoffice.user.associateclient.update.process.rules;

import com.personal.backoffice.user.associateclient.update.process.UpdateAssociatedUserClientProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateAssociatedUserClientRule implements IProcessRule<UpdateAssociatedUserClientProcess> {

    @Override
    public void apply(UpdateAssociatedUserClientProcess process) {

        var pLogger = LogFactory.builder(UpdateAssociatedUserClientProcess.class, UpdateAssociatedUserClientRule.class);

        var query = process.Query();
        var associatedUserClient = process.getInitObject();

        query.Field("users_id", associatedUserClient.getUser().getId());
        query.Where().Equ("users_id");
        query.Field("client_id", associatedUserClient.getClient().getId());
        query.Where().AndEqu("client_id");

        if (associatedUserClient.getUserRole().getId() != null) {
            query.Set("user_role_id", associatedUserClient.getUserRole().getId());
        }
        if (associatedUserClient.getUserRelation() != null) {
            query.Set("user_relation_id", associatedUserClient.getUserRelation().getId());
        }

        var update = UserServiceFactory.UpdateAssociatedUserClient().edit(query);

        if (update.getResult() == null) {
            process.addLog(pLogger.ERROR("Modificar asociación Usuario y Cliente", "Error al asociar usuario a cliente: " + update.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Modificar asociación Usuario y Cliente", "Asociación editada correctamente: " + update.getResult().getId()));

    }

}
