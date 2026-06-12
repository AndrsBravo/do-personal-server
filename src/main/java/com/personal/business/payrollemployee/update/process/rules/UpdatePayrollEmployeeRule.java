package com.personal.business.payrollemployee.update.process.rules;

import com.personal.business.payrollemployee.factories.PayrollEmployeeServiceFactory;
import com.personal.business.payrollemployee.update.process.UpdatePayrollEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdatePayrollEmployeeRule implements IProcessRule<UpdatePayrollEmployeeProcess> {

    @Override
    public void apply(UpdatePayrollEmployeeProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollEmployeeProcess.class, UpdatePayrollEmployeeRule.class);
        var payrollEmployee = process.getInitObject();
        var createPayrollEmployee = PayrollEmployeeServiceFactory.EditPayrollEmployee(payrollEmployee.getBusiness().getDbName());
        var result = createPayrollEmployee.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
