package com.personal.backoffice.user.associateclient.delete.process.rules;

import com.personal.backoffice.user.associateclient.delete.process.DeleteAssociatedUserClientProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteAssociatedUserClientRule implements IProcessRule<DeleteAssociatedUserClientProcess> {

    @Override
    public void apply(DeleteAssociatedUserClientProcess process) {

        var pLogger = LogFactory.builder(DeleteAssociatedUserClientProcess.class, DeleteAssociatedUserClientRule.class);

        var query = process.Query();
        var associatedUserClient = process.getInitObject();

        query.Field("users_id", associatedUserClient.getUser().getId());
        query.Where().Equ("users_id");
        query.Field("client_id", associatedUserClient.getClient().getId());
        query.Where().AndEqu("client_id");

        var associatedUserClientService = UserServiceFactory.DeleteAssociatedUserClientService();
        var result = associatedUserClientService.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar relación Usuario, Cliente", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar relación Usuario, Cliente", "Relación Usuario, Cliente eliminada con éxito"));

    }

}
