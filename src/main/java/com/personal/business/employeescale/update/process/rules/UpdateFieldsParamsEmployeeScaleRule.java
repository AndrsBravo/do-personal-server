package com.personal.business.employeescale.update.process.rules;

import com.personal.business.employeescale.update.process.UpdateEmployeeScaleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsEmployeeScaleRule implements IProcessRule<UpdateEmployeeScaleProcess> {

    @Override
    public void apply(UpdateEmployeeScaleProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeScaleProcess.class, UpdateFieldsParamsEmployeeScaleRule.class);

        var query = process.Query();

        var employeeScale = process.getInitObject();

        query.Field("id", employeeScale.getId());
        query.Where().Equ("id");

        if (employeeScale.getBusiness() != null) {
            query.Set("business_id", employeeScale.getBusiness().getId());
        }
        if (employeeScale.getEmployee() != null) {
            query.Set("employees_id", employeeScale.getEmployee().getId());
        }
        if (employeeScale.getHierarchy() != null) {
            query.Set("business_hierarchy_id", employeeScale.getHierarchy().getId());
        }
        if (employeeScale.getStartedAt() != null) {
            query.Set("es_started_at", employeeScale.getStartedAt().toString());
        }
        if (employeeScale.getEndedAt() != null) {
            query.Set("es_ended_at", employeeScale.getEndedAt().toString());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
