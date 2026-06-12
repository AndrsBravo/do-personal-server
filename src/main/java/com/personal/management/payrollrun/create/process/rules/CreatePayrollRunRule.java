package com.personal.management.payrollrun.create.process.rules;

import com.personal.management.payrollrun.create.process.CreatePayrollRunProcess;
import com.personal.management.payrollrun.factories.PayrollRunServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollRunRule implements IProcessRule<CreatePayrollRunProcess> {

    @Override
    public void apply(CreatePayrollRunProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunProcess.class, CreatePayrollRunRule.class);
        var createPayrollRun = PayrollRunServiceFactory.CreatePayrollRun();
        var result = createPayrollRun.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
