package com.personal.business.employeededuction.create.process.rules;

import com.personal.business.employeededuction.create.process.CreateEmployeeDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateEmployeeDeductionRule implements IProcessRule<CreateEmployeeDeductionProcess> {

    @Override
    public void apply(CreateEmployeeDeductionProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeDeductionProcess.class, ValidateEmployeeDeductionRule.class);
        var query = process.Query();

        var employeeDeduction = process.getInitObject();
        query.Field("id", employeeDeduction.getId());
        query.Field("business_id", employeeDeduction.getBusiness().getId());
        query.Field("employees_id", employeeDeduction.getEmployee().getId());
        query.Field("business_deductions_id", employeeDeduction.getDeduction().getId());
        query.Field("created_at", employeeDeduction.getCreatedAt().toString());
        query.Field("updated_at", employeeDeduction.getUpdatedAt().toString());
        query.Field("created_by", employeeDeduction.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
