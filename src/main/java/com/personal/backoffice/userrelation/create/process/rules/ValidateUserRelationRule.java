package com.personal.backoffice.userrelation.create.process.rules;

import com.personal.backoffice.userrelation.create.process.CreateUserRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateUserRelationRule implements IProcessRule<CreateUserRelationProcess> {

    @Override
    public void apply(CreateUserRelationProcess process) {

        var pLogger = LogFactory.builder(CreateUserRelationProcess.class, ValidateUserRelationRule.class);
        var query = process.Query();
        var userRelation = process.getInitObject();
        query.Field("id", userRelation.getId());
        query.Field("ur_title", userRelation.getTitle());
        query.Field("ur_relation", userRelation.getRelation());
        query.Field("ur_description", userRelation.getDescription());
        query.Field("ur_created_at", userRelation.getCreatedAt().toString());
        query.Field("ur_updated_at", userRelation.getUpdatedAt().toString());
        query.Field("ur_created_by", userRelation.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
