package com.personal.business.employeescale.create.process.rules;

import com.personal.business.employeescale.create.process.CreateEmployeeScaleProcess;
import com.personal.business.employeescale.factories.EmployeeScaleServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateEmployeeScaleRule implements IProcessRule<CreateEmployeeScaleProcess> {

    @Override
    public void apply(CreateEmployeeScaleProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeScaleProcess.class, CreateEmployeeScaleRule.class);
        var employeeScale = process.getInitObject();
        var createEmployeeScale = EmployeeScaleServiceFactory.CreateEmployeeScale(employeeScale.getBusiness().getDbName());
        var result = createEmployeeScale.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
