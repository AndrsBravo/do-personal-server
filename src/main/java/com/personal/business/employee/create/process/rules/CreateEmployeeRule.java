package com.personal.business.employee.create.process.rules;

import com.personal.business.employee.create.process.CreateEmployeeProcess;
import com.personal.business.employee.factories.EmployeeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateEmployeeRule implements IProcessRule<CreateEmployeeProcess> {

    @Override
    public void apply(CreateEmployeeProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeProcess.class, CreateEmployeeRule.class);
        var employee = process.getInitObject();
        var createEmployee = EmployeeServiceFactory.CreateEmployee(employee.getBusiness().getDbName());
        var result = createEmployee.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
