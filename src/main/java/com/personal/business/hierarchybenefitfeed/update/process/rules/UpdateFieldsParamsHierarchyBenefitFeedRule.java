package com.personal.business.hierarchybenefitfeed.update.process.rules;

import com.personal.business.hierarchybenefitfeed.update.process.UpdateHierarchyBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsHierarchyBenefitFeedRule implements IProcessRule<UpdateHierarchyBenefitFeedProcess> {

    @Override
    public void apply(UpdateHierarchyBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyBenefitFeedProcess.class, UpdateFieldsParamsHierarchyBenefitFeedRule.class);

        var query = process.Query();

        var hierarchyBenefitFeed = process.getInitObject();

        query.Field("id", hierarchyBenefitFeed.getId());
        query.Where().AndEqu("id");

        if (hierarchyBenefitFeed.getBusiness() != null) {
            query.Set("business_id", hierarchyBenefitFeed.getBusiness().getId());
        }

        if (hierarchyBenefitFeed.getBenefit() != null) {
            query.Set("business_benefits_id", hierarchyBenefitFeed.getBenefit().getId());
        }
        if (hierarchyBenefitFeed.getHierarchy() != null) {
            query.Set("business_hierarchy_id", hierarchyBenefitFeed.getHierarchy().getId());
        }
        if (hierarchyBenefitFeed.getTemporalFrequency() != null) {
            query.Set("temporal_frequency_id", hierarchyBenefitFeed.getTemporalFrequency().getId());
        }
        if (hierarchyBenefitFeed.getAmount() != null) {
            query.Set("hbf_amount", hierarchyBenefitFeed.getAmount().toString());
        }
        if (hierarchyBenefitFeed.getStartedAt() != null) {
            query.Set("hbf_started_at", hierarchyBenefitFeed.getStartedAt().toString());
        }
        if (hierarchyBenefitFeed.getEndedAt() != null) {
            query.Set("hbf_ended_at", hierarchyBenefitFeed.getEndedAt().toString());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
