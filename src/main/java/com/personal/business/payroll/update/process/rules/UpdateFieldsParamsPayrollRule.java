package com.personal.business.payroll.update.process.rules;

import com.personal.business.payroll.update.process.UpdatePayrollProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollRule implements IProcessRule<UpdatePayrollProcess> {

    @Override
    public void apply(UpdatePayrollProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollProcess.class, UpdateFieldsParamsPayrollRule.class);

        var query = process.Query();

        var payroll = process.getInitObject();

        query.Field("id", payroll.getId());
        query.Where().Equ("id");

        if (payroll.getPayroll() != null) {
            query.Set("pr_payroll", payroll.getPayroll());
        }
        if (payroll.getDescription() != null) {
            query.Set("pr_description", payroll.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
