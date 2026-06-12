package com.personal.business.user.update.process.rules;

import com.personal.business.user.factories.UserServiceFactory;
import com.personal.business.user.update.process.EditUserProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class EditUserRule implements IProcessRule<EditUserProcess> {

    @Override
    public void apply(EditUserProcess process) {

        var pLogger = LogFactory.builder(EditUserProcess.class, EditUserRule.class);

        var query = process.Query();
        var user = process.getInitObject();

        query.Field("id", user.getId());
        query.Where().Equ("id");

        var edit = UserServiceFactory.EditUser(user.getBusiness().getDbName()).edit(query);

        if (edit.getResult() == null) {
            process.addLog(pLogger.ERROR("Modificar usuario", "Error al modificar usuario: " + edit.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Modificar usuario", "Usuario editado correctamente: " + edit.getResult().getId()));

    }

}
