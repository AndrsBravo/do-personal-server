package com.personal.management.payrollrundeduction.create.process.rules;

import com.personal.management.payrollrundeduction.create.process.CreatePayrollRunDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollRunDeductionRule implements IProcessRule<CreatePayrollRunDeductionProcess> {

    @Override
    public void apply(CreatePayrollRunDeductionProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunDeductionProcess.class, ValidatePayrollRunDeductionRule.class);
        var query = process.Query();

        var payrollRunDeduction = process.getInitObject();
        query.Field("id", payrollRunDeduction.getId());
        query.Field("country_id", payrollRunDeduction.getCountry().getId());
        query.Field("payroll_runs_id", payrollRunDeduction.getPayrollRun().getId());
        query.Field("payroll_deductions_id", payrollRunDeduction.getDeduction().getId());
        query.Field("created_at", payrollRunDeduction.getCreatedAt().toString());
        query.Field("updated_at", payrollRunDeduction.getUpdatedAt().toString());
        query.Field("created_by", payrollRunDeduction.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
