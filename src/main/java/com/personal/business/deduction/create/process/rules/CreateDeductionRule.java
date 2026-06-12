package com.personal.business.deduction.create.process.rules;

import com.personal.business.deduction.create.process.CreateDeductionProcess;
import com.personal.business.deduction.factories.DeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateDeductionRule implements IProcessRule<CreateDeductionProcess> {

    @Override
    public void apply(CreateDeductionProcess process) {

        var pLogger = LogFactory.builder(CreateDeductionProcess.class, CreateDeductionRule.class);
        var deduction = process.getInitObject();
        var createDeduction = DeductionServiceFactory.CreateDeduction(deduction.getBusiness().getDbName());
        var result = createDeduction.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
