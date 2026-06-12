package com.personal.management.benefitcategory.create.process.rules;

import com.personal.management.benefitcategory.create.process.CreateBenefitCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateBenefitCategoryRule implements IProcessRule<CreateBenefitCategoryProcess> {

    @Override
    public void apply(CreateBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateBenefitCategoryProcess.class, ValidateBenefitCategoryRule.class);
        var query = process.Query();

        var benefitCategory = process.getInitObject();
        query.Field("id", benefitCategory.getId());
        query.Field("bc_title", benefitCategory.getTitle());
        query.Field("bc_category", benefitCategory.getCategory());
        query.Field("bc_description", benefitCategory.getDescription());
        query.Field("created_at", benefitCategory.getCreatedAt().toString());
        query.Field("updated_at", benefitCategory.getUpdatedAt().toString());
        query.Field("created_by", benefitCategory.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
