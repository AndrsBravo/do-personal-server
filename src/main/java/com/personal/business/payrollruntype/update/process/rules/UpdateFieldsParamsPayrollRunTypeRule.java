package com.personal.business.payrollruntype.update.process.rules;

import com.personal.business.payrollruntype.update.process.UpdatePayrollRunTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollRunTypeRule implements IProcessRule<UpdatePayrollRunTypeProcess> {

    @Override
    public void apply(UpdatePayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunTypeProcess.class, UpdateFieldsParamsPayrollRunTypeRule.class);

        var query = process.Query();

        var payrollRunType = process.getInitObject();

        query.Field("id", payrollRunType.getId());
        query.Where().AndEqu("id");

        if (payrollRunType.getType() != null) {
            query.Set("prt_type", payrollRunType.getType());
        }
        if (payrollRunType.getDescription() != null) {
            query.Set("prt_description", payrollRunType.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
