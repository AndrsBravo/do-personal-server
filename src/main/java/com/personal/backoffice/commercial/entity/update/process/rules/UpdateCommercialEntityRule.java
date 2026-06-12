package com.personal.backoffice.commercial.entity.update.process.rules;

import com.personal.backoffice.commercial.entity.factories.CommercialEntityServiceFactory;
import com.personal.backoffice.commercial.entity.update.process.UpdateCommercialEntityProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateCommercialEntityRule implements IProcessRule<UpdateCommercialEntityProcess> {

    @Override
    public void apply(UpdateCommercialEntityProcess process) {

        var pLogger = LogFactory.builder(UpdateCommercialEntityProcess.class, UpdateCommercialEntityRule.class);
        var createCommercialEntity = CommercialEntityServiceFactory.EditCommercialEntity();
        var result = createCommercialEntity.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
