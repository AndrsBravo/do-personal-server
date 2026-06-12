package com.personal.backoffice.commercial.entity.update.process.rules;

import com.personal.backoffice.commercial.entity.update.process.UpdateCommercialEntityProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsCommercialEntityRule implements IProcessRule<UpdateCommercialEntityProcess> {

    @Override
    public void apply(UpdateCommercialEntityProcess process) {

        var pLogger = LogFactory.builder(UpdateCommercialEntityProcess.class, UpdateFieldsParamsCommercialEntityRule.class);

        var query = process.Query();

        var commercialEntity = process.getInitObject();

        query.Field("id", commercialEntity.getId());
        query.Where().AndEqu("id");

        if (commercialEntity.getEntity() != null) {
            query.Set("ce_entity", commercialEntity.getEntity());
        }
        if (commercialEntity.getDescription() != null) {
            query.Set("ce_description", commercialEntity.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
