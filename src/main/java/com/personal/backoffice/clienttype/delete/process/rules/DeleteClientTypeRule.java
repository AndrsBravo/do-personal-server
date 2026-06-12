package com.personal.backoffice.clienttype.delete.process.rules;

import com.personal.backoffice.clienttype.delete.process.DeleteClientTypeProcess;
import com.personal.backoffice.clienttype.factories.ClientTypeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteClientTypeRule implements IProcessRule<DeleteClientTypeProcess> {

    @Override
    public void apply(DeleteClientTypeProcess process) {

        var pLogger = LogFactory.builder(DeleteClientTypeProcess.class, DeleteClientTypeRule.class);

        var query = process.Query();
        var clientType = process.getInitObject();

        query.Field("id", clientType.getId());
        query.Where().Equ("id");

        var createClientType = ClientTypeServiceFactory.DeleteClientType();
        var result = createClientType.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
