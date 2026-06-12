package com.personal.management.payrollbenefit.create.process.rules;

import com.personal.management.payrollbenefit.create.process.CreatePayrollBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollBenefitRule implements IProcessRule<CreatePayrollBenefitProcess> {

    @Override
    public void apply(CreatePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollBenefitProcess.class, ValidatePayrollBenefitRule.class);
        var query = process.Query();

        var payrollBenefit = process.getInitObject();
        query.Field("id", payrollBenefit.getId());
        query.Field("payrolls_id", payrollBenefit.getPayroll().getId());
        query.Field("business_benefits_id", payrollBenefit.getBenefit().getId());
        query.Field("created_at", payrollBenefit.getCreatedAt().toString());
        query.Field("updated_at", payrollBenefit.getUpdatedAt().toString());
        query.Field("created_by", payrollBenefit.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
