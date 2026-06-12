package com.personal.business.hierarchydeductionfeed.create.process.rules;

import com.personal.business.hierarchydeductionfeed.create.process.CreateHierarchyDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateHierarchyDeductionFeedRule implements IProcessRule<CreateHierarchyDeductionFeedProcess> {

    @Override
    public void apply(CreateHierarchyDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(CreateHierarchyDeductionFeedProcess.class, ValidateHierarchyDeductionFeedRule.class);
        var query = process.Query();

        var hierarchyDeductionFeed = process.getInitObject();
        query.Field("id", hierarchyDeductionFeed.getId());
        query.Field("business_id", hierarchyDeductionFeed.getBusiness().getId());
        query.Field("business_hierarchy_id", hierarchyDeductionFeed.getHierarchy().getId());
        query.Field("business_deductions_id", hierarchyDeductionFeed.getDeduction().getId());
        query.Field("temporal_frequency_id", hierarchyDeductionFeed.getTemporalFrequency().getId());
        query.Field("hdf_amount", hierarchyDeductionFeed.getAmount().toString());
        query.Field("hdf_started_at", hierarchyDeductionFeed.getStartedAt().toString());
        query.Field("hdf_ended_at", hierarchyDeductionFeed.getEndedAt().toString());
        query.Field("created_at", hierarchyDeductionFeed.getCreatedAt().toString());
        query.Field("updated_at", hierarchyDeductionFeed.getUpdatedAt().toString());
        query.Field("created_by", hierarchyDeductionFeed.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
