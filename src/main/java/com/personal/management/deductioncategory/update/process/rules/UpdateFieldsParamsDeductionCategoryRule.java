package com.personal.management.deductioncategory.update.process.rules;

import com.personal.management.deductioncategory.update.process.UpdateDeductionCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsDeductionCategoryRule implements IProcessRule<UpdateDeductionCategoryProcess> {

    @Override
    public void apply(UpdateDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateDeductionCategoryProcess.class, UpdateFieldsParamsDeductionCategoryRule.class);

        var query = process.Query();

        var deductionCategory = process.getInitObject();

        query.Field("id", deductionCategory.getId());
        query.Where().Equ("id");

        if (deductionCategory.getCategory() != null) {
            query.Set("dc_category", deductionCategory.getCategory());
        }
        if (deductionCategory.getDescription() != null) {
            query.Set("dc_description", deductionCategory.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
