package com.personal.backoffice.usertype.filter.process.rules;

import com.personal.backoffice.usertype.factories.UserTypeServiceFactory;
import com.personal.backoffice.usertype.filter.process.FilterUserTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterUserTypeRule implements IProcessRule<FilterUserTypeProcess> {

    @Override
    public void apply(FilterUserTypeProcess process) {

        var pLogger = LogFactory.builder(FilterUserTypeProcess.class, FilterUserTypeRule.class);
        var query = process.Query();
        var userTypeFilter = process.getInitObject();

        if (userTypeFilter.getId() != null) {
            query.Field("id", userTypeFilter.getId());
            query.Where().Field("id", userTypeFilter.getId());
        }

        if (userTypeFilter.getType() != null) {
            query.Field("ust_type", userTypeFilter.getType());
            query.Where().AndEqu("ust_type");
        }

        var filterUserType = UserTypeServiceFactory.FilterUserTypes();

        var result = filterUserType.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
