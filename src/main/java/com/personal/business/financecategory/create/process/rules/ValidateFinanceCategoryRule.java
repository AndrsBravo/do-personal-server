package com.personal.business.financecategory.create.process.rules;

import com.personal.business.financecategory.create.process.CreateFinanceCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateFinanceCategoryRule implements IProcessRule<CreateFinanceCategoryProcess> {

    @Override
    public void apply(CreateFinanceCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateFinanceCategoryProcess.class, ValidateFinanceCategoryRule.class);
        var query = process.Query();

        var financeCategory = process.getInitObject();
        query.Field("id", financeCategory.getId());
        query.Field("fc_title", financeCategory.getTitle());
        query.Field("fc_category", financeCategory.getCategory());
        query.Field("fc_benefit_or_deduction", financeCategory.getBenefitOrDeduction().toString());
        query.Field("fc_description", financeCategory.getDescription());
        query.Field("created_at", financeCategory.getCreatedAt().toString());
        query.Field("updated_at", financeCategory.getUpdatedAt().toString());
        query.Field("created_by", financeCategory.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
