package com.personal.backoffice.business.process.create.rules;

import com.personal.backoffice.business.process.create.CreateBusinessProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;
import com.personal.shared.query.Query;

public class AssociateBusinessUserRule implements IProcessRule<CreateBusinessProcess> {

    @Override
    public void apply(CreateBusinessProcess process) {

        var pLogger = LogFactory.builder(CreateBusinessProcess.class, AssociateBusinessUserRule.class);
        var associateBusiness = UserServiceFactory.AssociateUserBusiness();

        var business = process.getInitObject();

        var query = new Query();

        query.Field("business_id", business.getId());
        query.Field("users_id", business.getCreatedBy().getId());
        query.Field("created_at", business.getCreatedAt().toString());
        query.Field("updated_at", business.getUpdatedAt().toString());
        query.Field("created_by", business.getCreatedBy().getId());

        query.Field("user_role_id", process.Query().getParams().get("user_role_id"));
        query.Field("user_relation_id", process.Query().getParams().get("user_relation_id"));

        var result = associateBusiness.create(query);

        if (result.getNotification() != null) {

            process.addLog(pLogger.ERROR("Asociar Empresa a Usuario", result.getNotification().message()));
            process.stopWithErrors();
            return;
        }

        process.addLog(pLogger.INFO("Asociar Empresa a Usuario", "Tipo de Usuario creado con éxito"));

    }

}
