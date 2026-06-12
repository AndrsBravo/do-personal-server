package com.personal.business.employeededuction.update.process.rules;

import com.personal.business.employeededuction.factories.EmployeeDeductionServiceFactory;
import com.personal.business.employeededuction.update.process.UpdateEmployeeDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateEmployeeDeductionRule implements IProcessRule<UpdateEmployeeDeductionProcess> {

    @Override
    public void apply(UpdateEmployeeDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeDeductionProcess.class, UpdateEmployeeDeductionRule.class);
        var employeeDeduction = process.getInitObject();
        var createEmployeeDeduction = EmployeeDeductionServiceFactory.EditEmployeeDeduction(employeeDeduction.getBusiness().getDbName());
        var result = createEmployeeDeduction.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
