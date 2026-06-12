package com.personal.business.employeededuction.create.process.rules;

import com.personal.business.employeededuction.create.process.CreateEmployeeDeductionProcess;
import com.personal.business.employeededuction.factories.EmployeeDeductionServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreateEmployeeDeductionRule implements IProcessRule<CreateEmployeeDeductionProcess> {

    @Override
    public void apply(CreateEmployeeDeductionProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeDeductionProcess.class, CreateEmployeeDeductionRule.class);
        var employeeDeduction = process.getInitObject();
        var createEmployeeDeduction = EmployeeDeductionServiceFactory.CreateEmployeeDeduction(employeeDeduction.getBusiness().getDbName());
        var result = createEmployeeDeduction.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
