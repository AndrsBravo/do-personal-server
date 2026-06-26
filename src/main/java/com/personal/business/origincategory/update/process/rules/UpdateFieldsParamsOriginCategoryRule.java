package com.personal.business.origincategory.update.process.rules;

import com.personal.business.origincategory.update.process.UpdateOriginCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsOriginCategoryRule implements IProcessRule<UpdateOriginCategoryProcess> {

    @Override
    public void apply(UpdateOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(UpdateOriginCategoryProcess.class, UpdateFieldsParamsOriginCategoryRule.class);

        var query = process.Query();

        var originCategory = process.getInitObject();

        query.Field("id", originCategory.getId());
        query.Where().Equ("id");

        if (originCategory.getOrigin() != null) {
            query.Set("co_origin", originCategory.getOrigin());
        }
        if (originCategory.getDescription() != null) {
            query.Set("co_description", originCategory.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
