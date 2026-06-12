package com.personal.business.deductionrate.update.process.rules;

import com.personal.business.deductionrate.factories.DeductionRateServiceFactory;
import com.personal.business.deductionrate.update.process.UpdateDeductionRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateDeductionRateRule implements IProcessRule<UpdateDeductionRateProcess> {

    @Override
    public void apply(UpdateDeductionRateProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionRateProcess.class, UpdateDeductionRateRule.class);
        var deductionRate = process.getInitObject();
        var createDeductionRate = DeductionRateServiceFactory.EditDeductionRate(deductionRate.getBusiness().getDbName());
        var result = createDeductionRate.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
