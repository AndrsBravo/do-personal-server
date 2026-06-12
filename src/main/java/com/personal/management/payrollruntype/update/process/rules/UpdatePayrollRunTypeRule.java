package com.personal.management.payrollruntype.update.process.rules;

import com.personal.management.payrollruntype.factories.PayrollRunTypeServiceFactory;
import com.personal.management.payrollruntype.update.process.UpdatePayrollRunTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRunTypeRule implements IProcessRule<UpdatePayrollRunTypeProcess> {

    @Override
    public void apply(UpdatePayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunTypeProcess.class, UpdatePayrollRunTypeRule.class);
        var createPayrollRunType = PayrollRunTypeServiceFactory.EditPayrollRunType();
        var result = createPayrollRunType.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
