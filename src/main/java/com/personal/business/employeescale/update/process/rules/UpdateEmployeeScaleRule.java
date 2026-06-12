package com.personal.business.employeescale.update.process.rules;

import com.personal.business.employeescale.factories.EmployeeScaleServiceFactory;
import com.personal.business.employeescale.update.process.UpdateEmployeeScaleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateEmployeeScaleRule implements IProcessRule<UpdateEmployeeScaleProcess> {

    @Override
    public void apply(UpdateEmployeeScaleProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeScaleProcess.class, UpdateEmployeeScaleRule.class);
        var employeeScale = process.getInitObject();
        var createEmployeeScale = EmployeeScaleServiceFactory.EditEmployeeScale(employeeScale.getBusiness().getDbName());
        var result = createEmployeeScale.edit(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
