package com.personal.backoffice.userrelation.delete.process.rules;

import com.personal.backoffice.userrelation.delete.process.DeleteUserRelationProcess;
import com.personal.backoffice.userrelation.factories.UserRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteUserRelationRule implements IProcessRule<DeleteUserRelationProcess> {

    @Override
    public void apply(DeleteUserRelationProcess process) {

        var pLogger = LogFactory.builder(DeleteUserRelationProcess.class, DeleteUserRelationRule.class);

        var query = process.Query();
        var userRelation = process.getInitObject();

        query.Field("id", userRelation.getId());
        query.Where().Equ("id");

        var createUserRelation = UserRelationServiceFactory.DeleteUserRelation();
        var result = createUserRelation.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
