package com.personal.backoffice.commercial.plandetail.update.process.rules;

import com.personal.backoffice.commercial.plandetail.update.process.UpdateCommercialPlanDetailProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsCommercialPlanDetailRule implements IProcessRule<UpdateCommercialPlanDetailProcess> {

    @Override
    public void apply(UpdateCommercialPlanDetailProcess process) {

        var pLogger = LogFactory.builder(UpdateCommercialPlanDetailProcess.class, UpdateFieldsParamsCommercialPlanDetailRule.class);

        var query = process.Query();

        var commercialPlan = process.getInitObject();

        query.Field("id", commercialPlan.getId());
        query.Where().AndEqu("id");

        if (commercialPlan.getPlan() != null) {
            query.Set("commercial_plan_id", commercialPlan.getPlan().getId());
        }
        if (commercialPlan.getEntity() != null) {
            query.Set("commercial_entities_id", commercialPlan.getEntity().getId());
        }
        if (commercialPlan.getQuantity() != null) {
            query.Set("cpd_quantity", commercialPlan.getQuantity().toString());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
