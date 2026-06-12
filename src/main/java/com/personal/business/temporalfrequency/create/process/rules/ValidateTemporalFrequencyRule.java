package com.personal.business.temporalfrequency.create.process.rules;

import com.personal.business.temporalfrequency.create.process.CreateTemporalFrequencyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateTemporalFrequencyRule implements IProcessRule<CreateTemporalFrequencyProcess> {

    @Override
    public void apply(CreateTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(CreateTemporalFrequencyProcess.class, ValidateTemporalFrequencyRule.class);
        var query = process.Query();

        var temporalFrequency = process.getInitObject();
        query.Field("id", temporalFrequency.getId());
        query.Field("tf_title", temporalFrequency.getTitle());
        query.Field("tf_category", temporalFrequency.getFrequency());
        query.Field("tf_description", temporalFrequency.getDescription());
        query.Field("created_at", temporalFrequency.getCreatedAt().toString());
        query.Field("updated_at", temporalFrequency.getUpdatedAt().toString());
        query.Field("created_by", temporalFrequency.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
