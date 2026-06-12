package com.personal.business.payrollemployee.create.process.rules;

import com.personal.business.payrollemployee.create.process.CreatePayrollEmployeeProcess;
import com.personal.business.payrollemployee.factories.PayrollEmployeeServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class CreatePayrollEmployeeRule implements IProcessRule<CreatePayrollEmployeeProcess> {

    @Override
    public void apply(CreatePayrollEmployeeProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollEmployeeProcess.class, CreatePayrollEmployeeRule.class);
        var payrollEmployee = process.getInitObject();
        var createPayrollEmployee = PayrollEmployeeServiceFactory.CreatePayrollEmployee(payrollEmployee.getBusiness().getDbName());
        var result = createPayrollEmployee.create(process.Query());

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Crear nuevo Tipo de Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
