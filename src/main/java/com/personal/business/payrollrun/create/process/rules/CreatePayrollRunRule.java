package com.personal.business.payrollrun.create.process.rules;

import com.personal.business.payrollrun.create.process.CreatePayrollRunProcess;
import com.personal.business.payrollrun.factories.PayrollRunServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRunRule implements IProcessRule<CreatePayrollRunProcess> {

    @Override
    public void apply(CreatePayrollRunProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunProcess.class, CreatePayrollRunRule.class);
        var payrollRun = process.getInitObject();
        var createPayrollRun = PayrollRunServiceFactory.CreatePayrollRun(payrollRun.getBusiness().getDbName());
        var result = createPayrollRun.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
