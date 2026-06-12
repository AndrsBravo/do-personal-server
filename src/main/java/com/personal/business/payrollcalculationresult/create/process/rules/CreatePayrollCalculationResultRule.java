package com.personal.business.payrollcalculationresult.create.process.rules;

import com.personal.business.payrollcalculationresult.create.process.CreatePayrollCalculationResultProcess;
import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollCalculationResultRule implements IProcessRule<CreatePayrollCalculationResultProcess> {

    @Override
    public void apply(CreatePayrollCalculationResultProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollCalculationResultProcess.class, CreatePayrollCalculationResultRule.class);
        var payrollCalculationResult = process.getInitObject();
        var createPayrollCalculationResult = PayrollCalculationResultServiceFactory.CreatePayrollCalculationResult(payrollCalculationResult.getBusiness().getDbName());
        var result = createPayrollCalculationResult.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
