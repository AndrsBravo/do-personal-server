package com.personal.management.deductionrate.create.process.rules;

import com.personal.management.deductionrate.create.process.CreateDeductionRateProcess;
import com.personal.management.deductionrate.factories.DeductionRateServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateDeductionRateRule implements IProcessRule<CreateDeductionRateProcess> {

    @Override
    public void apply(CreateDeductionRateProcess process) {

        var pLogger = LogFactory.builder(CreateDeductionRateProcess.class, CreateDeductionRateRule.class);
        var createDeductionRate = DeductionRateServiceFactory.CreateDeductionRate();
        var result = createDeductionRate.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
