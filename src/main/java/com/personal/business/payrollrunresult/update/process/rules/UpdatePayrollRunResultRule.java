package com.personal.business.payrollrunresult.update.process.rules;

import com.personal.business.payrollrunresult.factories.PayrollRunResultServiceFactory;
import com.personal.business.payrollrunresult.update.process.UpdatePayrollRunResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRunResultRule implements IProcessRule<UpdatePayrollRunResultProcess> {

    @Override
    public void apply(UpdatePayrollRunResultProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunResultProcess.class, UpdatePayrollRunResultRule.class);
        var payrollRunResult = process.getInitObject();
        var createPayrollRunResult = PayrollRunResultServiceFactory.EditPayrollRunResult(payrollRunResult.getBusiness().getDbName());
        var result = createPayrollRunResult.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
