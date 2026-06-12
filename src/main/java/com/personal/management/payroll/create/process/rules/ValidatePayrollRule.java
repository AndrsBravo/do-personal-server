package com.personal.management.payroll.create.process.rules;

import com.personal.management.payroll.create.process.CreatePayrollProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollRule implements IProcessRule<CreatePayrollProcess> {

    @Override
    public void apply(CreatePayrollProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollProcess.class, ValidatePayrollRule.class);
        var query = process.Query();

        var payroll = process.getInitObject();
        query.Field("id", payroll.getId());
        query.Field("pr_title", payroll.getTitle());
        query.Field("pr_payroll", payroll.getPayroll());
        query.Field("pr_description", payroll.getDescription());
        query.Field("created_at", payroll.getCreatedAt().toString());
        query.Field("updated_at", payroll.getUpdatedAt().toString());
        query.Field("created_by", payroll.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
