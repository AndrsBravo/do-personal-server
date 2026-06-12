package com.personal.business.payrollemployee.create.process.rules;

import com.personal.business.payrollemployee.create.process.CreatePayrollEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollEmployeeRule implements IProcessRule<CreatePayrollEmployeeProcess> {

    @Override
    public void apply(CreatePayrollEmployeeProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollEmployeeProcess.class, ValidatePayrollEmployeeRule.class);
        var query = process.Query();

        var payrollEmployee = process.getInitObject();
        query.Field("id", payrollEmployee.getId());
        query.Field("business_id", payrollEmployee.getBusiness().getId());
        query.Field("payrolls_id", payrollEmployee.getPayroll().getId());
        query.Field("employees_id", payrollEmployee.getEmployee().getId());
        query.Field("created_at", payrollEmployee.getCreatedAt().toString());
        query.Field("updated_at", payrollEmployee.getUpdatedAt().toString());
        query.Field("created_by", payrollEmployee.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
