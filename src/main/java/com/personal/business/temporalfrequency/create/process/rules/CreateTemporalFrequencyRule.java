package com.personal.business.temporalfrequency.create.process.rules;

import com.personal.business.temporalfrequency.create.process.CreateTemporalFrequencyProcess;
import com.personal.business.temporalfrequency.factories.TemporalFrequencyServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateTemporalFrequencyRule implements IProcessRule<CreateTemporalFrequencyProcess> {

    @Override
    public void apply(CreateTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(CreateTemporalFrequencyProcess.class, CreateTemporalFrequencyRule.class);
        var temporalFrequency = process.getInitObject();
        var createTemporalFrequency = TemporalFrequencyServiceFactory.CreateTemporalFrequency(temporalFrequency.getBusiness().getDbName());
        var result = createTemporalFrequency.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
