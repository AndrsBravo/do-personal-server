package com.personal.backoffice.commercial.entity.create.process.rules;

import com.personal.backoffice.commercial.entity.create.process.CreateCommercialEntityProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateCommercialEntityRule implements IProcessRule<CreateCommercialEntityProcess> {

    @Override
    public void apply(CreateCommercialEntityProcess process) {

        var pLogger = LogFactory.builder(CreateCommercialEntityProcess.class, ValidateCommercialEntityRule.class);
        var query = process.Query();
        var commercialEntity = process.getInitObject();
        query.Field("id", commercialEntity.getId());
        query.Field("ce_title", commercialEntity.getTitle());
        query.Field("ce_entity", commercialEntity.getEntity());
        query.Field("ce_description", commercialEntity.getDescription());
        query.Field("ce_created_at", commercialEntity.getCreatedAt().toString());
        query.Field("ce_updated_at", commercialEntity.getUpdatedAt().toString());
        query.Field("ce_created_by", commercialEntity.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
