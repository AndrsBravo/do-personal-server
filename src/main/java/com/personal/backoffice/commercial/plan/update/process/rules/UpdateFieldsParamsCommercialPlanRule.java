package com.personal.backoffice.commercial.plan.update.process.rules;

import com.personal.backoffice.commercial.plan.update.process.UpdateCommercialPlanProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsCommercialPlanRule implements IProcessRule<UpdateCommercialPlanProcess> {

    @Override
    public void apply(UpdateCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(UpdateCommercialPlanProcess.class, UpdateFieldsParamsCommercialPlanRule.class);

        var query = process.Query();

        var commercialPlan = process.getInitObject();

        query.Field("id", commercialPlan.getId());
        query.Where().AndEqu("id");

        if (commercialPlan.getPlan() != null) {
            query.Set("cp_plan", commercialPlan.getPlan());
        }
        if (commercialPlan.getDescription() != null) {
            query.Set("cp_description", commercialPlan.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
