package com.personal.business.employee.update.process.rules;

import com.personal.business.employee.factories.EmployeeServiceFactory;
import com.personal.business.employee.update.process.UpdateEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateEmployeeRule implements IProcessRule<UpdateEmployeeProcess> {

    @Override
    public void apply(UpdateEmployeeProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeProcess.class, UpdateEmployeeRule.class);
        var employee = process.getInitObject();
        var createEmployee = EmployeeServiceFactory.EditEmployee(employee.getBusiness().getDbName());
        var result = createEmployee.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
