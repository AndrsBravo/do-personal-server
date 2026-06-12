package com.personal.business.payrollcalculation.create.process.rules;

import com.personal.business.payrollcalculation.create.process.CreatePayrollCalculationProcess;
import com.personal.business.payrollcalculation.factories.PayrollCalculationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollCalculationRule implements IProcessRule<CreatePayrollCalculationProcess> {

    @Override
    public void apply(CreatePayrollCalculationProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollCalculationProcess.class, CreatePayrollCalculationRule.class);
        var payrollCalculation = process.getInitObject();
        var createPayrollCalculation = PayrollCalculationServiceFactory.CreatePayrollCalculation(payrollCalculation.getBusiness().getDbName());
        var result = createPayrollCalculation.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
