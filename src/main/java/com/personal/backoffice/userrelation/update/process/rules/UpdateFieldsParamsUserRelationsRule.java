package com.personal.backoffice.userrelation.update.process.rules;

import com.personal.backoffice.userrelation.update.process.UpdateUserRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsUserRelationsRule implements IProcessRule<UpdateUserRelationProcess> {

    @Override
    public void apply(UpdateUserRelationProcess process) {

        var pLogger = LogFactory.builder(UpdateUserRelationProcess.class, UpdateFieldsParamsUserRelationsRule.class);

        var query = process.Query();

        var userRelation = process.getInitObject();

        query.Field("id", userRelation.getId());
        query.Where().AndEqu("id");

        if (userRelation.getRelation() != null) {
            query.Set("ur_relation", userRelation.getRelation());
        }
        if (userRelation.getTitle() != null) {
            query.Set("ur_title", userRelation.getTitle());
        }
        if (userRelation.getDescription() != null) {
            query.Set("ur_description", userRelation.getDescription());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
