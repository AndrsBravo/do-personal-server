package com.personal.management.benefitcategory.update.process.rules;

import com.personal.management.benefitcategory.update.process.UpdateBenefitCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsBenefitCategoryRule implements IProcessRule<UpdateBenefitCategoryProcess> {

    @Override
    public void apply(UpdateBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateBenefitCategoryProcess.class, UpdateFieldsParamsBenefitCategoryRule.class);

        var query = process.Query();

        var benefitCategory = process.getInitObject();

        query.Field("id", benefitCategory.getId());
        query.Where().Equ("id");

        if (benefitCategory.getCategory() != null) {
            query.Set("bc_category", benefitCategory.getCategory());
        }
        if (benefitCategory.getDescription() != null) {
            query.Set("bc_description", benefitCategory.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
