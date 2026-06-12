package com.personal.business.employee.update.process.rules;

import com.personal.business.employee.update.process.UpdateEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsEmployeeRule implements IProcessRule<UpdateEmployeeProcess> {

    @Override
    public void apply(UpdateEmployeeProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeProcess.class, UpdateFieldsParamsEmployeeRule.class);

        var query = process.Query();

        var employee = process.getInitObject();

        query.Field("id", employee.getId());
        query.Where().AndEqu("id");

        if (employee.getBusiness() != null) {
            query.Set("business_id", employee.getBusiness().getId());
        }
        if (employee.getName() != null) {
            query.Set("e_name", employee.getName());
        }
        if (employee.getLastName() != null) {
            query.Set("e_last_name", employee.getLastName());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
