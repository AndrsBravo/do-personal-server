package com.personal.management.payrollrun.update.process.rules;

import com.personal.management.payrollrun.factories.PayrollRunServiceFactory;
import com.personal.management.payrollrun.update.process.UpdatePayrollRunProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRunRule implements IProcessRule<UpdatePayrollRunProcess> {

    @Override
    public void apply(UpdatePayrollRunProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunProcess.class, UpdatePayrollRunRule.class);
        var createPayrollRun = PayrollRunServiceFactory.EditPayrollRun();
        var result = createPayrollRun.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
