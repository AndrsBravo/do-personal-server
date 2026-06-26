package com.personal.backoffice.user.filter.process.rules;

import com.personal.backoffice.user.filter.process.FilterUserProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UserIdFilterRule implements IProcessRule<FilterUserProcess> {

    @Override
    public void apply(FilterUserProcess process) {
        var pLogger = LogFactory.builder(FilterUserProcess.class, UserIdFilterRule.class);
        var query = process.Query();
        var user = process.getInitObject();

        if (user.getId() == null) {
            process.addLog(pLogger.WARNING("Filter User", "User id is null"));
            return;
        }
        query.Field("id", user.getId());
        query.Where().Field("id", user.getId());

        process.addLog(pLogger.INFO("Filter User", "Filtering by id: " + user.getId()));
    }

}
