package com.personal.backoffice.client.create.process.rules;

import com.personal.backoffice.client.create.process.CreateClientProcess;
import com.personal.backoffice.userrelation.factories.UserRelationServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class ValidateUserClientRelationRule implements IProcessRule<CreateClientProcess> {

    @Override
    public void apply(CreateClientProcess process) {

        var pLogger = LogFactory.builder(CreateClientProcess.class, ValidateUserClientRelationRule.class);

        var query = new Query();

        query.Field("ur_relation", "owner");
        query.Where().Equ("ur_relation");

        var filteredUserRelation = UserRelationServiceFactory.FilterUserRelations().filter(query);

        if (filteredUserRelation.getResult() == null || filteredUserRelation.getResult().isEmpty()) {
            process.addLog(pLogger.WARNING("Validar relación con usuario", "No se ha podido validar la relación de usuario"));
            process.stopWithErrors();
            return;
        }

        var userRelation = filteredUserRelation.getResult().getFirst();
        process.Query().Field("user_relation_id", userRelation.getId());
        process.addLog(pLogger.INFO("Validar relación con usuario", "La relación de usuario fue validada satisfactoriamente."));

    }

}
