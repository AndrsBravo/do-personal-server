package com.personal.business.employee.create.process.rules;

import com.personal.business.employee.create.process.CreateEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateEmployeeRule implements IProcessRule<CreateEmployeeProcess> {

    @Override
    public void apply(CreateEmployeeProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeProcess.class, ValidateEmployeeRule.class);
        var query = process.Query();

        var employee = process.getInitObject();
        query.Field("id", employee.getId());
        query.Field("business_id", employee.getBusiness().getId());
        query.Field("e_name", employee.getName());
        query.Field("e_last_name", employee.getLastName());
        query.Field("created_at", employee.getCreatedAt().toString());
        query.Field("updated_at", employee.getUpdatedAt().toString());
        query.Field("created_by", employee.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo empleado", "Empleado creado con éxito"));

    }

}
