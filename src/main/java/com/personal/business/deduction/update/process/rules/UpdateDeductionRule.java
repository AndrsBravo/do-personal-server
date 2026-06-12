package com.personal.business.deduction.update.process.rules;

import com.personal.business.deduction.factories.DeductionServiceFactory;
import com.personal.business.deduction.update.process.UpdateDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateDeductionRule implements IProcessRule<UpdateDeductionProcess> {

    @Override
    public void apply(UpdateDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionProcess.class, UpdateDeductionRule.class);
        var deduction = process.getInitObject();
        var createDeduction = DeductionServiceFactory.EditDeduction(deduction.getBusiness().getDbName());
        var result = createDeduction.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
