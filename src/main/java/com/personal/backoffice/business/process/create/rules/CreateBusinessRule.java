package com.personal.backoffice.business.process.create.rules;

import com.personal.backoffice.business.factories.BusinessServiceFactory;
import com.personal.backoffice.business.process.create.CreateBusinessProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateBusinessRule implements IProcessRule<CreateBusinessProcess> {

    @Override
    public void apply(CreateBusinessProcess process) {

        var pLogger = LogFactory.builder(CreateBusinessProcess.class, CreateBusinessRule.class);
        var createBusiness = BusinessServiceFactory.CreateBusiness();
        var result = createBusiness.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
