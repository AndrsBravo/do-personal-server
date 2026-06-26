package com.personal.backoffice.user.associatebusiness.filter.process.rules;

import com.personal.backoffice.user.associatebusiness.filter.process.FilterAssociatedUserBusinessProcess;
import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterAssociatedUserBusinessRule implements IProcessRule<FilterAssociatedUserBusinessProcess> {

    @Override
    public void apply(FilterAssociatedUserBusinessProcess process) {

        var pLogger = LogFactory.builder(FilterAssociatedUserBusinessProcess.class, FilterAssociatedUserBusinessRule.class);
        var query = process.Query();
        var associatedUserBusinessFilter = process.getInitObject();

        if (associatedUserBusinessFilter.getId() != null) {
            query.Field("id", associatedUserBusinessFilter.getId());
            query.Where().Field("id", associatedUserBusinessFilter.getId());
        }

        if (associatedUserBusinessFilter.getUserId() != null) {
            query.Field("users_id", associatedUserBusinessFilter.getUserId());
            query.Where().AndEqu("users_id");
        }

        if (associatedUserBusinessFilter.getBusinessId() != null) {
            query.Field("business_id", associatedUserBusinessFilter.getBusinessId());
            query.Where().AndEqu("business_id");
        }

        if (associatedUserBusinessFilter.getUserRoleId() != null) {
            query.Field("user_role_id", associatedUserBusinessFilter.getUserRoleId());
            query.Where().AndEqu("user_role_id");
        }
        if (associatedUserBusinessFilter.getUserRelationId() != null) {
            query.Field("user_relation_id", associatedUserBusinessFilter.getUserRelationId());
            query.Where().AndEqu("user_relation_id");
        }

        var filterAssociatedUserBusiness = UserServiceFactory.FilterAssociatedUserBusiness();

        var result = filterAssociatedUserBusiness.filter(query);
        process.setResult(result.getResult());

        process.addLog(pLogger.INFO("Filtrar Usuarios Asociados a Clientes", "Usuarios Asociados a Clientes filtrados con éxito"));

    }

}
