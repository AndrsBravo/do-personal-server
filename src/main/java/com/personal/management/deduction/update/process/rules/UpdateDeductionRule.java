package com.personal.management.deduction.update.process.rules;

import com.personal.management.deduction.factories.DeductionServiceFactory;
import com.personal.management.deduction.update.process.UpdateDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateDeductionRule implements IProcessRule<UpdateDeductionProcess> {

    @Override
    public void apply(UpdateDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionProcess.class, UpdateDeductionRule.class);
        var createDeduction = DeductionServiceFactory.EditDeduction();
        var result = createDeduction.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
