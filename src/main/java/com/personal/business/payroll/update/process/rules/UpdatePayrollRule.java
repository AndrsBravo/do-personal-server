package com.personal.business.payroll.update.process.rules;

import com.personal.business.payroll.factories.PayrollServiceFactory;
import com.personal.business.payroll.update.process.UpdatePayrollProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRule implements IProcessRule<UpdatePayrollProcess> {

    @Override
    public void apply(UpdatePayrollProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollProcess.class, UpdatePayrollRule.class);
        var payroll = process.getInitObject();
        var createPayroll = PayrollServiceFactory.EditPayroll(payroll.getBusiness().getDbName());
        var result = createPayroll.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
