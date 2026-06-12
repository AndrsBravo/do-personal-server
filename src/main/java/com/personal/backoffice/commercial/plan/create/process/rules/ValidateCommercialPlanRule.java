package com.personal.backoffice.commercial.plan.create.process.rules;

import com.personal.backoffice.commercial.plan.create.process.CreateCommercialPlanProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateCommercialPlanRule implements IProcessRule<CreateCommercialPlanProcess> {

    @Override
    public void apply(CreateCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(CreateCommercialPlanProcess.class, ValidateCommercialPlanRule.class);
        var query = process.Query();
        var commercialPlan = process.getInitObject();
        query.Field("id", commercialPlan.getId());
        query.Field("cp_title", commercialPlan.getTitle());
        query.Field("cp_plan", commercialPlan.getPlan());
        query.Field("cp_description", commercialPlan.getDescription());
        query.Field("cp_created_at", commercialPlan.getCreatedAt().toString());
        query.Field("cp_updated_at", commercialPlan.getUpdatedAt().toString());
        query.Field("cp_created_by", commercialPlan.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
