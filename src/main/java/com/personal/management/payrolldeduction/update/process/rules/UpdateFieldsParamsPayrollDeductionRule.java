package com.personal.management.payrolldeduction.update.process.rules;

import com.personal.management.payrolldeduction.update.process.UpdatePayrollDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollDeductionRule implements IProcessRule<UpdatePayrollDeductionProcess> {

    @Override
    public void apply(UpdatePayrollDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollDeductionProcess.class, UpdateFieldsParamsPayrollDeductionRule.class);

        var query = process.Query();

        var payrollDeduction = process.getInitObject();

        query.Field("id", payrollDeduction.getId());
        query.Where().Equ("id");

        if (payrollDeduction.getDeduction() != null) {
            query.Set("business_deductions_id", payrollDeduction.getDeduction().getId());
        }
        if (payrollDeduction.getPayroll() != null) {
            query.Set("payrolls_id", payrollDeduction.getPayroll().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
