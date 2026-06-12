package com.personal.business.payrollrunresult.create.process.rules;

import com.personal.business.payrollrunresult.create.process.CreatePayrollRunResultProcess;
import com.personal.business.payrollrunresult.factories.PayrollRunResultServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRunResultRule implements IProcessRule<CreatePayrollRunResultProcess> {

    @Override
    public void apply(CreatePayrollRunResultProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunResultProcess.class, CreatePayrollRunResultRule.class);
        var payrollRunResult = process.getInitObject();
        var createPayrollRunResult = PayrollRunResultServiceFactory.CreatePayrollRunResult(payrollRunResult.getBusiness().getDbName());
        var result = createPayrollRunResult.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
