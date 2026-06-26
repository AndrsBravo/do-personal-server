package com.personal.backoffice.userrole.filter.process.rules;

import com.personal.backoffice.userrole.factories.UserRoleServiceFactory;
import com.personal.backoffice.userrole.filter.process.FilterUserRoleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterUserRoleRule implements IProcessRule<FilterUserRoleProcess> {

    @Override
    public void apply(FilterUserRoleProcess process) {

        var pLogger = LogFactory.builder(FilterUserRoleProcess.class, FilterUserRoleRule.class);
        var query = process.Query();
        var userRoleFilter = process.getInitObject();

        if (userRoleFilter.getId() != null) {
            query.Field("id", userRoleFilter.getId());
            query.Where().Field("id", userRoleFilter.getId());
        }

        var filterUserRole = UserRoleServiceFactory.FilterUserRoles();

        var result = filterUserRole.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Roles", "Filtered user roles with properties: " + query.getKeyPair()));
    }

}
