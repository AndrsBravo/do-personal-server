package com.personal.management.benefit.update.process.rules;

import com.personal.management.benefit.update.process.UpdateBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsBenefitRule implements IProcessRule<UpdateBenefitProcess> {

    @Override
    public void apply(UpdateBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitProcess.class, UpdateFieldsParamsBenefitRule.class);

        var query = process.Query();

        var benefit = process.getInitObject();

        query.Field("id", benefit.getId());
        query.Where().Equ("id");

        if (benefit.getBenefit() != null) {
            query.Set("bb_benefit", benefit.getBenefit());
        }
        if (benefit.getDescription() != null) {
            query.Set("bb_description", benefit.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
