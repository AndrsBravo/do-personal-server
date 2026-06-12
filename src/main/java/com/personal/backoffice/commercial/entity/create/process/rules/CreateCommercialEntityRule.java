package com.personal.backoffice.commercial.entity.create.process.rules;

import com.personal.backoffice.commercial.entity.create.process.CreateCommercialEntityProcess;
import com.personal.backoffice.commercial.entity.factories.CommercialEntityServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateCommercialEntityRule implements IProcessRule<CreateCommercialEntityProcess> {

    @Override
    public void apply(CreateCommercialEntityProcess process) {

        var pLogger = LogFactory.builder(CreateCommercialEntityProcess.class, CreateCommercialEntityRule.class);
        var createCommercialEntity = CommercialEntityServiceFactory.CreateCommercialEntity();
        var result = createCommercialEntity.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
