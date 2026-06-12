package com.personal.backoffice.business.process.update.rules;

import com.personal.backoffice.business.factories.BusinessServiceFactory;
import com.personal.backoffice.business.process.update.UpdateBusinessProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateBusinessRule implements IProcessRule<UpdateBusinessProcess> {

    @Override
    public void apply(UpdateBusinessProcess process) {

        var pLogger = LogFactory.builder(UpdateBusinessProcess.class, UpdateBusinessRule.class);
        var createBusiness = BusinessServiceFactory.EditBusiness();
        var result = createBusiness.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
