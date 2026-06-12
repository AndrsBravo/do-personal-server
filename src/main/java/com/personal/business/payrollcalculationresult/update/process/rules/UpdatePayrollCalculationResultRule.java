package com.personal.business.payrollcalculationresult.update.process.rules;

import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultServiceFactory;
import com.personal.business.payrollcalculationresult.update.process.UpdatePayrollCalculationResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollCalculationResultRule implements IProcessRule<UpdatePayrollCalculationResultProcess> {

    @Override
    public void apply(UpdatePayrollCalculationResultProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollCalculationResultProcess.class, UpdatePayrollCalculationResultRule.class);
        var payrollCalculationResult = process.getInitObject();
        var createPayrollCalculationResult = PayrollCalculationResultServiceFactory.EditPayrollCalculationResult(payrollCalculationResult.getBusiness().getDbName());
        var result = createPayrollCalculationResult.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
