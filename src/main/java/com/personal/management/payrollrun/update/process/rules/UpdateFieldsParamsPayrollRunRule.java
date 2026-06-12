package com.personal.management.payrollrun.update.process.rules;

import com.personal.management.payrollrun.update.process.UpdatePayrollRunProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollRunRule implements IProcessRule<UpdatePayrollRunProcess> {

    @Override
    public void apply(UpdatePayrollRunProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunProcess.class, UpdateFieldsParamsPayrollRunRule.class);

        var query = process.Query();

        var payrollRun = process.getInitObject();

        query.Field("id", payrollRun.getId());
        query.Where().AndEqu("id");

        if (payrollRun.getPayroll() != null) {
            query.Set("payrolls_id", payrollRun.getPayroll().getId());
        }
        if (payrollRun.getDescription() != null) {
            query.Set("prr_description", payrollRun.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
