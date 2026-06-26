package com.personal.management.payrollrundeduction.update.process.rules;

import com.personal.management.payrollrundeduction.update.process.UpdatePayrollRunDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollRunDeductionRule implements IProcessRule<UpdatePayrollRunDeductionProcess> {

    @Override
    public void apply(UpdatePayrollRunDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunDeductionProcess.class, UpdateFieldsParamsPayrollRunDeductionRule.class);

        var query = process.Query();

        var payrollRunDeduction = process.getInitObject();

        query.Field("id", payrollRunDeduction.getId());
        query.Where().Equ("id");

        if (payrollRunDeduction.getDeduction() != null) {
            query.Set("payroll_deductions_id", payrollRunDeduction.getDeduction().getId());
        }
        if (payrollRunDeduction.getPayrollRun() != null) {
            query.Set("payroll_runs_id", payrollRunDeduction.getPayrollRun().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
