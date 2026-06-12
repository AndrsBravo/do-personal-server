package com.personal.business.deductioncategory.create.process.rules;

import com.personal.business.deductioncategory.create.process.CreateDeductionCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateDeductionCategoryRule implements IProcessRule<CreateDeductionCategoryProcess> {

    @Override
    public void apply(CreateDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateDeductionCategoryProcess.class, ValidateDeductionCategoryRule.class);
        var query = process.Query();

        var deductionCategory = process.getInitObject();
        query.Field("id", deductionCategory.getId());
        query.Field("dc_title", deductionCategory.getTitle());
        query.Field("dc_category", deductionCategory.getCategory());
        query.Field("dc_description", deductionCategory.getDescription());
        query.Field("created_at", deductionCategory.getCreatedAt().toString());
        query.Field("updated_at", deductionCategory.getUpdatedAt().toString());
        query.Field("created_by", deductionCategory.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
