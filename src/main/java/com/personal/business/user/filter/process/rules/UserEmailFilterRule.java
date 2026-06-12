package com.personal.business.user.filter.process.rules;

import com.personal.business.user.filter.process.FilterUserProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UserEmailFilterRule implements IProcessRule<FilterUserProcess> {

    @Override
    public void apply(FilterUserProcess process) {
        var pLogger = LogFactory.builder(FilterUserProcess.class, UserEmailFilterRule.class);
        var query = process.Query();

        var user = process.getInitObject();

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            process.addLog(pLogger.WARNING("Filter User", "User email is null or empty"));
            return;
        }
        query.Field("us_email", user.getEmail());
        query.Where().AndEqu("us_email");

        process.addLog(pLogger.INFO("Filter User", "Filtering by email: " + user.getEmail()));

    }

}
