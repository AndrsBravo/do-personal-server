package com.personal.business.hierarchydeductionfeed.update.process.rules;

import com.personal.business.hierarchydeductionfeed.update.process.UpdateHierarchyDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsHierarchyDeductionFeedRule implements IProcessRule<UpdateHierarchyDeductionFeedProcess> {

    @Override
    public void apply(UpdateHierarchyDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(UpdateHierarchyDeductionFeedProcess.class, UpdateFieldsParamsHierarchyDeductionFeedRule.class);

        var query = process.Query();

        var hierarchyDeductionFeed = process.getInitObject();

        query.Field("id", hierarchyDeductionFeed.getId());
        query.Where().AndEqu("id");

        if (hierarchyDeductionFeed.getBusiness() != null) {
            query.Set("business_id", hierarchyDeductionFeed.getBusiness().getId());
        }

        if (hierarchyDeductionFeed.getDeduction() != null) {
            query.Set("business_deductions_id", hierarchyDeductionFeed.getDeduction().getId());
        }
        if (hierarchyDeductionFeed.getHierarchy() != null) {
            query.Set("business_hierarchy_id", hierarchyDeductionFeed.getHierarchy().getId());
        }
        if (hierarchyDeductionFeed.getTemporalFrequency() != null) {
            query.Set("temporal_frequency_id", hierarchyDeductionFeed.getTemporalFrequency().getId());
        }
        if (hierarchyDeductionFeed.getAmount() != null) {
            query.Set("hdf_amount", hierarchyDeductionFeed.getAmount().toString());
        }
        if (hierarchyDeductionFeed.getStartedAt() != null) {
            query.Set("hdf_started_at", hierarchyDeductionFeed.getStartedAt().toString());
        }
        if (hierarchyDeductionFeed.getEndedAt() != null) {
            query.Set("hdf_ended_at", hierarchyDeductionFeed.getEndedAt().toString());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
