package com.personal.business.financecategory.update.process.rules;

import com.personal.business.financecategory.update.process.UpdateFinanceCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsFinanceCategoryRule implements IProcessRule<UpdateFinanceCategoryProcess> {

    @Override
    public void apply(UpdateFinanceCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateFinanceCategoryProcess.class, UpdateFieldsParamsFinanceCategoryRule.class);

        var query = process.Query();

        var financeCategory = process.getInitObject();

        query.Field("id", financeCategory.getId());
        query.Where().Equ("id");

        if (financeCategory.getCategory() != null) {
            query.Set("fc_category", financeCategory.getCategory());
        }
        if (financeCategory.getDescription() != null) {
            query.Set("fc_description", financeCategory.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
