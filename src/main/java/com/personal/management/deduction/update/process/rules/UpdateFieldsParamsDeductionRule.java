package com.personal.management.deduction.update.process.rules;

import com.personal.management.deduction.update.process.UpdateDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsDeductionRule implements IProcessRule<UpdateDeductionProcess> {

    @Override
    public void apply(UpdateDeductionProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionProcess.class, UpdateFieldsParamsDeductionRule.class);

        var query = process.Query();

        var deduction = process.getInitObject();

        query.Field("id", deduction.getId());
        query.Where().Equ("id");

        if (deduction.getDeduction() != null) {
            query.Set("bd_deduction", deduction.getDeduction());
        }
        if (deduction.getDescription() != null) {
            query.Set("bd_description", deduction.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
