package com.personal.management.origincategory.create.process.rules;

import com.personal.management.origincategory.create.process.CreateOriginCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateOriginCategoryRule implements IProcessRule<CreateOriginCategoryProcess> {

    @Override
    public void apply(CreateOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(CreateOriginCategoryProcess.class, ValidateOriginCategoryRule.class);
        var query = process.Query();

        var originCategory = process.getInitObject();
        query.Field("id", originCategory.getId());
        query.Field("co_title", originCategory.getTitle());
        query.Field("co_origin", originCategory.getOrigin());
        query.Field("co_description", originCategory.getDescription());
        query.Field("created_at", originCategory.getCreatedAt().toString());
        query.Field("updated_at", originCategory.getUpdatedAt().toString());
        query.Field("created_by", originCategory.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
