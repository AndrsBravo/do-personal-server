package com.personal.business.temporalfrequency.update.process.rules;

import com.personal.business.temporalfrequency.factories.TemporalFrequencyServiceFactory;
import com.personal.business.temporalfrequency.update.process.UpdateTemporalFrequencyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateTemporalFrequencyRule implements IProcessRule<UpdateTemporalFrequencyProcess> {

    @Override
    public void apply(UpdateTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(UpdateTemporalFrequencyProcess.class, UpdateTemporalFrequencyRule.class);
        var temporalFrequency = process.getInitObject();
        var createTemporalFrequency = TemporalFrequencyServiceFactory.EditTemporalFrequency(temporalFrequency.getBusiness().getDbName());
        var result = createTemporalFrequency.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
