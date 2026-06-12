package com.personal.management.payrollrun.create.process.rules;

import com.personal.management.payrollrun.create.process.CreatePayrollRunProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollRunRule implements IProcessRule<CreatePayrollRunProcess> {

    @Override
    public void apply(CreatePayrollRunProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunProcess.class, ValidatePayrollRunRule.class);
        var query = process.Query();

        var payrollRun = process.getInitObject();
        query.Field("id", payrollRun.getId());
        query.Field("prr_title", payrollRun.getTitle());
        query.Field("payrolls_id", payrollRun.getPayroll().getId());
        query.Field("payroll_runs_type_id", payrollRun.getPayrollRunType().getId());
        query.Field("prr_description", payrollRun.getDescription());
        query.Field("created_at", payrollRun.getCreatedAt().toString());
        query.Field("updated_at", payrollRun.getUpdatedAt().toString());
        query.Field("created_by", payrollRun.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
