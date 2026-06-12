package com.personal.business.payrollcalculation.update.process.rules;

import com.personal.business.payrollcalculation.factories.PayrollCalculationServiceFactory;
import com.personal.business.payrollcalculation.update.process.UpdatePayrollCalculationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollCalculationRule implements IProcessRule<UpdatePayrollCalculationProcess> {

    @Override
    public void apply(UpdatePayrollCalculationProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollCalculationProcess.class, UpdatePayrollCalculationRule.class);
        var payrollCalculation = process.getInitObject();
        var createPayrollCalculation = PayrollCalculationServiceFactory.EditPayrollCalculation(payrollCalculation.getBusiness().getDbName());
        var result = createPayrollCalculation.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
