package com.personal.management.payrolldeduction.create.process.rules;

import com.personal.management.payrolldeduction.create.process.CreatePayrollDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollDeductionRule implements IProcessRule<CreatePayrollDeductionProcess> {

    @Override
    public void apply(CreatePayrollDeductionProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollDeductionProcess.class, ValidatePayrollDeductionRule.class);
        var query = process.Query();

        var payrollDeduction = process.getInitObject();
        query.Field("id", payrollDeduction.getId());
        query.Field("payrolls_id", payrollDeduction.getPayroll().getId());
        query.Field("business_deductions_id", payrollDeduction.getDeduction().getId());
        query.Field("created_at", payrollDeduction.getCreatedAt().toString());
        query.Field("updated_at", payrollDeduction.getUpdatedAt().toString());
        query.Field("created_by", payrollDeduction.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
