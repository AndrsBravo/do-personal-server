package com.personal.management.payrollruntype.create.process.rules;

import com.personal.management.payrollruntype.create.process.CreatePayrollRunTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollRunTypeRule implements IProcessRule<CreatePayrollRunTypeProcess> {

    @Override
    public void apply(CreatePayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunTypeProcess.class, ValidatePayrollRunTypeRule.class);
        var query = process.Query();
        var payrollRunType = process.getInitObject();
        query.Field("id", payrollRunType.getId());
        query.Field("prt_type", payrollRunType.getType());
        query.Field("prt_title", payrollRunType.getTitle());
        query.Field("prt_description", payrollRunType.getDescription());
        query.Field("created_at", payrollRunType.getCreatedAt().toString());
        query.Field("updated_at", payrollRunType.getUpdatedAt().toString());
        query.Field("created_by", payrollRunType.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
