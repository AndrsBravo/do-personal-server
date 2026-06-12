package com.personal.backoffice.user.associateclient.filter.process.rules;

import com.personal.backoffice.user.associateclient.filter.process.FilterAssociatedUserClientProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterAssociatedUserClientRule implements IProcessRule<FilterAssociatedUserClientProcess> {

    @Override
    public void apply(FilterAssociatedUserClientProcess process) {

        var pLogger = LogFactory.builder(FilterAssociatedUserClientProcess.class, FilterAssociatedUserClientRule.class);
        var query = process.Query();
        var associatedUserClientFilter = process.getInitObject();

        if (associatedUserClientFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (associatedUserClientFilter.getId() != null) {
            query.Field("id", associatedUserClientFilter.getId());
            query.Where().AndEqu("id");
        }

        if (associatedUserClientFilter.getUserId() != null) {
            query.Field("users_id", associatedUserClientFilter.getUserId());
            query.Where().AndEqu("users_id");
        }

        if (associatedUserClientFilter.getClientId() != null) {
            query.Field("client_id", associatedUserClientFilter.getClientId());
            query.Where().AndEqu("client_id");
        }

        if (associatedUserClientFilter.getUserRoleId() != null) {
            query.Field("user_role_id", associatedUserClientFilter.getUserRoleId());
            query.Where().AndEqu("user_role_id");
        }
        if (associatedUserClientFilter.getUserRelationId() != null) {
            query.Field("user_relation_id", associatedUserClientFilter.getUserRelationId());
            query.Where().AndEqu("user_relation_id");
        }

        var filterAssociatedUserClient = UserServiceFactory.FilterAssociatedUserClient();

        var result = filterAssociatedUserClient.filter(query);
        process.setResult(result.getResult());

        process.addLog(pLogger.INFO("Filtrar Usuarios Asociados a Clientes", "Usuarios Asociados a Clientes filtrados con éxito"));

    }

}
