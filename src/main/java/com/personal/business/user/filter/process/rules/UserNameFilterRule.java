package com.personal.business.user.filter.process.rules;

import com.personal.business.user.filter.process.FilterUserProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UserNameFilterRule implements IProcessRule<FilterUserProcess> {

    @Override
    public void apply(FilterUserProcess process) {
        var pLogger = LogFactory.builder(FilterUserProcess.class, UserNameFilterRule.class);
        var query = process.Query();

        var user = process.getInitObject();

        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            process.addLog(pLogger.WARNING("Filter User", "User name is null or empty"));
            return;
        }
        query.Field("user_name", user.getUserName());
        query.Where().AndEqu("user_name");

        process.addLog(pLogger.INFO("Filter User", "Filtering by user name: " + user.getUserName()));

    }

}
