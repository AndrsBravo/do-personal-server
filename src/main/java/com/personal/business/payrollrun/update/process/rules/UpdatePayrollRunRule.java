package com.personal.business.payrollrun.update.process.rules;

import com.personal.business.payrollrun.factories.PayrollRunServiceFactory;
import com.personal.business.payrollrun.update.process.UpdatePayrollRunProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRunRule implements IProcessRule<UpdatePayrollRunProcess> {

    @Override
    public void apply(UpdatePayrollRunProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunProcess.class, UpdatePayrollRunRule.class);
        var payrollRun = process.getInitObject();
        var createPayrollRun = PayrollRunServiceFactory.EditPayrollRun(payrollRun.getBusiness().getDbName());
        var result = createPayrollRun.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
