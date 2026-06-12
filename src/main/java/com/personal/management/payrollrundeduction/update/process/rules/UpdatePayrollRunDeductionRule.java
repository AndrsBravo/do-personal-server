package com.personal.management.payrollrundeduction.update.process.rules;

import com.personal.management.payrollrundeduction.factories.PayrollRunDeductionServiceFactory;
import com.personal.management.payrollrundeduction.update.process.UpdatePayrollRunDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollRunDeductionRule implements IProcessRule<UpdatePayrollRunDeductionProcess> {

    @Override
    public void apply(UpdatePayrollRunDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunDeductionProcess.class, UpdatePayrollRunDeductionRule.class);
        var createPayrollRunDeduction = PayrollRunDeductionServiceFactory.EditPayrollRunDeduction();
        var result = createPayrollRunDeduction.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
