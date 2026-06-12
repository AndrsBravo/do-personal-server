package com.personal.backoffice.user.update.process.rules;

import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.backoffice.user.update.process.EditUserProcess;
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

        if (user.getUserType().getId() != null) {
            query.Set("user_types_id", user.getUserType().getId());
        }
        if (user.getNames() != null) {
            query.Set("us_name", user.getNames());
        }
        if (user.getLastNames() != null) {
            query.Set("us_last_name", user.getLastNames());
        }

        var edit = UserServiceFactory.EditUser().edit(query);

        if (edit.getResult() == null) {
            process.addLog(pLogger.ERROR("Modificar usuario", "Error al modificar usuario: " + edit.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Modificar usuario", "Usuario editado correctamente: " + edit.getResult().getId()));

    }

}
