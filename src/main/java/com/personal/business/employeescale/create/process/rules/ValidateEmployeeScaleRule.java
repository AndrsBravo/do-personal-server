package com.personal.business.employeescale.create.process.rules;

import com.personal.business.employeescale.create.process.CreateEmployeeScaleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateEmployeeScaleRule implements IProcessRule<CreateEmployeeScaleProcess> {

    @Override
    public void apply(CreateEmployeeScaleProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeScaleProcess.class, ValidateEmployeeScaleRule.class);
        var query = process.Query();

        var employeeScale = process.getInitObject();
        query.Field("id", employeeScale.getId());
        query.Field("business_id", employeeScale.getBusiness().getId());
        query.Field("business_hierarchy_id", employeeScale.getHierarchy().getId());
        query.Field("employees_id", employeeScale.getEmployee().getId());
        query.Field("es_started_at", employeeScale.getStartedAt().toString());
        query.Field("es_ended_at", employeeScale.getEndedAt().toString());
        query.Field("created_at", employeeScale.getCreatedAt().toString());
        query.Field("updated_at", employeeScale.getUpdatedAt().toString());
        query.Field("created_by", employeeScale.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
