package com.personal.business.payrollemployee.update.process.rules;

import com.personal.business.payrollemployee.update.process.UpdatePayrollEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollEmployeeRule implements IProcessRule<UpdatePayrollEmployeeProcess> {

    @Override
    public void apply(UpdatePayrollEmployeeProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollEmployeeProcess.class, UpdateFieldsParamsPayrollEmployeeRule.class);

        var query = process.Query();

        var payrollEmployee = process.getInitObject();

        query.Field("id", payrollEmployee.getId());
        query.Where().AndEqu("id");

        if (payrollEmployee.getBusiness() != null) {
            query.Set("business_id", payrollEmployee.getBusiness().getId());
        }
        if (payrollEmployee.getEmployee() != null) {
            query.Set("employees_id", payrollEmployee.getEmployee().getId());
        }
        if (payrollEmployee.getPayroll() != null) {
            query.Set("payrolls_id", payrollEmployee.getPayroll().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
