package com.personal.management.payrolldeduction.update.process.rules;

import com.personal.management.payrolldeduction.factories.PayrollDeductionServiceFactory;
import com.personal.management.payrolldeduction.update.process.UpdatePayrollDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollDeductionRule implements IProcessRule<UpdatePayrollDeductionProcess> {

    @Override
    public void apply(UpdatePayrollDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollDeductionProcess.class, UpdatePayrollDeductionRule.class);
        var createPayrollDeduction = PayrollDeductionServiceFactory.EditPayrollDeduction();
        var result = createPayrollDeduction.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
