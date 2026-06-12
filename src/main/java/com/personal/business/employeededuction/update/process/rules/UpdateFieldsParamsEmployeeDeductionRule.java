package com.personal.business.employeededuction.update.process.rules;

import com.personal.business.employeededuction.update.process.UpdateEmployeeDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsEmployeeDeductionRule implements IProcessRule<UpdateEmployeeDeductionProcess> {

    @Override
    public void apply(UpdateEmployeeDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeDeductionProcess.class, UpdateFieldsParamsEmployeeDeductionRule.class);

        var query = process.Query();

        var employeeDeduction = process.getInitObject();

        query.Field("id", employeeDeduction.getId());
        query.Where().AndEqu("id");

        if (employeeDeduction.getDeduction() != null) {
            query.Set("business_deductions_id", employeeDeduction.getDeduction().getId());
        }
        if (employeeDeduction.getEmployee() != null) {
            query.Set("employees_id", employeeDeduction.getEmployee().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
