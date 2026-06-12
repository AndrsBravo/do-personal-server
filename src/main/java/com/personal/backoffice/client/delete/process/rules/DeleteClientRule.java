package com.personal.backoffice.client.delete.process.rules;

import com.personal.backoffice.client.factories.ClientServiceFactory;
import com.personal.backoffice.client.delete.process.DeleteClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteClientRule implements IProcessRule<DeleteClientProcess> {

    @Override
    public void apply(DeleteClientProcess process) {

        var pLogger = LogFactory.builder(DeleteClientProcess.class, DeleteClientRule.class);

        var query = process.Query();
        var client = process.getInitObject();

        query.Field("id", client.getId());
        query.Where().Equ("id");

        var createClient = ClientServiceFactory.DeleteClient();
        var result = createClient.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
