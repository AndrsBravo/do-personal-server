package com.personal.backoffice.usertype.delete.process.rules;

import com.personal.backoffice.usertype.delete.process.DeleteUserTypeProcess;
import com.personal.backoffice.usertype.factories.UserTypeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteUserTypeRule implements IProcessRule<DeleteUserTypeProcess> {

    @Override
    public void apply(DeleteUserTypeProcess process) {

        var pLogger = LogFactory.builder(DeleteUserTypeProcess.class, DeleteUserTypeRule.class);

        var query = process.Query();
        var userType = process.getInitObject();

        query.Field("id", userType.getId());
        query.Where().Equ("id");

        var createUserType = UserTypeServiceFactory.DeleteUserType();
        var result = createUserType.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
