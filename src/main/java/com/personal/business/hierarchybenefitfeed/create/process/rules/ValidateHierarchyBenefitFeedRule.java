package com.personal.business.hierarchybenefitfeed.create.process.rules;

import com.personal.business.hierarchybenefitfeed.create.process.CreateHierarchyBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateHierarchyBenefitFeedRule implements IProcessRule<CreateHierarchyBenefitFeedProcess> {

    @Override
    public void apply(CreateHierarchyBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyBenefitFeedProcess.class, ValidateHierarchyBenefitFeedRule.class);
        var query = process.Query();

        var hierarchyBenefitFeed = process.getInitObject();
        query.Field("id", hierarchyBenefitFeed.getId());
        query.Field("business_id", hierarchyBenefitFeed.getBusiness().getId());
        query.Field("business_hierarchy_id", hierarchyBenefitFeed.getHierarchy().getId());
        query.Field("business_benefits_id", hierarchyBenefitFeed.getBenefit().getId());
        query.Field("temporal_frequency_id", hierarchyBenefitFeed.getTemporalFrequency().getId());
        query.Field("hbf_amount", hierarchyBenefitFeed.getAmount().toString());
        query.Field("hbf_started_at", hierarchyBenefitFeed.getStartedAt().toString());
        query.Field("hbf_ended_at", hierarchyBenefitFeed.getEndedAt().toString());
        query.Field("created_at", hierarchyBenefitFeed.getCreatedAt().toString());
        query.Field("updated_at", hierarchyBenefitFeed.getUpdatedAt().toString());
        query.Field("created_by", hierarchyBenefitFeed.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
