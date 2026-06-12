package com.personal.backoffice.usertype.update.process.rules;

import com.personal.backoffice.usertype.factories.UserTypeServiceFactory;
import com.personal.backoffice.usertype.update.process.UpdateUserTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateUserTypeRule implements IProcessRule<UpdateUserTypeProcess> {

    @Override
    public void apply(UpdateUserTypeProcess process) {

        var pLogger = LogFactory.builder(UpdateUserTypeProcess.class, UpdateUserTypeRule.class);
        var createUserType = UserTypeServiceFactory.EditUserType();
        var result = createUserType.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
