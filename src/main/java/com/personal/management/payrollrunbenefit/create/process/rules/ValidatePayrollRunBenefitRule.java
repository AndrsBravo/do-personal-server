package com.personal.management.payrollrunbenefit.create.process.rules;

import com.personal.management.payrollrunbenefit.create.process.CreatePayrollRunBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollRunBenefitRule implements IProcessRule<CreatePayrollRunBenefitProcess> {

    @Override
    public void apply(CreatePayrollRunBenefitProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunBenefitProcess.class, ValidatePayrollRunBenefitRule.class);
        var query = process.Query();

        var payrollRunBenefit = process.getInitObject();
        query.Field("id", payrollRunBenefit.getId());
        query.Field("payroll_runs_id", payrollRunBenefit.getPayrollRun().getId());
        query.Field("payroll_benefits_id", payrollRunBenefit.getBenefit().getId());
        query.Field("created_at", payrollRunBenefit.getCreatedAt().toString());
        query.Field("updated_at", payrollRunBenefit.getUpdatedAt().toString());
        query.Field("created_by", payrollRunBenefit.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
