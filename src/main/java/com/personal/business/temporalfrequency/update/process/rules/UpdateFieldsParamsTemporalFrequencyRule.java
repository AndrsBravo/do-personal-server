package com.personal.business.temporalfrequency.update.process.rules;

import com.personal.business.temporalfrequency.update.process.UpdateTemporalFrequencyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsTemporalFrequencyRule implements IProcessRule<UpdateTemporalFrequencyProcess> {

    @Override
    public void apply(UpdateTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(UpdateTemporalFrequencyProcess.class, UpdateFieldsParamsTemporalFrequencyRule.class);

        var query = process.Query();

        var temporalFrequency = process.getInitObject();

        query.Field("id", temporalFrequency.getId());
        query.Where().Equ("id");

        if (temporalFrequency.getFrequency() != null) {
            query.Set("tf_category", temporalFrequency.getFrequency());
        }
        if (temporalFrequency.getDescription() != null) {
            query.Set("tf_description", temporalFrequency.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
