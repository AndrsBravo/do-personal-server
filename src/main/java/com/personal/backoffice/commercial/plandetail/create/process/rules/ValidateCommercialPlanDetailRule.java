package com.personal.backoffice.commercial.plandetail.create.process.rules;

import com.personal.backoffice.commercial.plandetail.create.process.CreateCommercialPlanDetailProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateCommercialPlanDetailRule implements IProcessRule<CreateCommercialPlanDetailProcess> {

    @Override
    public void apply(CreateCommercialPlanDetailProcess process) {

        var pLogger = LogFactory.builder(CreateCommercialPlanDetailProcess.class, ValidateCommercialPlanDetailRule.class);
        var query = process.Query();
        var commercialPlan = process.getInitObject();
        query.Field("id", commercialPlan.getId());
        query.Field("commercial_entities_id", commercialPlan.getEntity().getId());
        query.Field("commercial_plan_id", commercialPlan.getPlan().getId());
        query.Field("cpd_quantity", commercialPlan.getQuantity().toString());
        query.Field("cpd_created_at", commercialPlan.getCreatedAt().toString());
        query.Field("cpd_updated_at", commercialPlan.getUpdatedAt().toString());
        query.Field("cpd_created_by", commercialPlan.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
