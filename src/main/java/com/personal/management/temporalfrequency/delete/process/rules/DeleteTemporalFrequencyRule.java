package com.personal.management.temporalfrequency.delete.process.rules;

import com.personal.management.temporalfrequency.delete.process.DeleteTemporalFrequencyProcess;
import com.personal.management.temporalfrequency.factories.TemporalFrequencyServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class DeleteTemporalFrequencyRule implements IProcessRule<DeleteTemporalFrequencyProcess> {

    @Override
    public void apply(DeleteTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(DeleteTemporalFrequencyProcess.class, DeleteTemporalFrequencyRule.class);

        var query = process.Query();
        var temporalFrequency = process.getInitObject();

        query.Field("id", temporalFrequency.getId());
        query.Where().Equ("id");

        var createTemporalFrequency = TemporalFrequencyServiceFactory.DeleteTemporalFrequency();
        var result = createTemporalFrequency.delete(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Eliminar Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Eliminar Tipo de Usuario", "Tipo de Usuario eliminado con éxito"));

    }

}
