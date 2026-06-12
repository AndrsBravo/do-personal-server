package com.personal.backoffice.client.commercialplan.add.process.rules;

import com.personal.backoffice.client.commercialplan.add.process.AddClientCommercialPlanProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateClientCommercialPlanRule implements IProcessRule<AddClientCommercialPlanProcess> {

    @Override
    public void apply(AddClientCommercialPlanProcess process) {

        var pLogger = LogFactory.builder(AddClientCommercialPlanProcess.class, ValidateClientCommercialPlanRule.class);
        var query = process.Query();
        var clientCommercialPlan = process.getInitObject();
        query.Field("id", clientCommercialPlan.getId());
        query.Field("client_id", clientCommercialPlan.getClient().getId());
        query.Field("commercial_plan_id", clientCommercialPlan.getCommercialPlan().getId());
        query.Field("created_at", clientCommercialPlan.getCreatedAt().toString());
        query.Field("updated_at", clientCommercialPlan.getUpdatedAt().toString());
        query.Field("created_by", clientCommercialPlan.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nuevo Tipo de Usuario", "Tipo de Usuario creado con éxito"));

    }

}
