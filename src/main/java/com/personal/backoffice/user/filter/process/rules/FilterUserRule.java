package com.personal.backoffice.user.filter.process.rules;

import com.personal.backoffice.user.factories.UserServiceFactory;
import com.personal.backoffice.user.filter.process.FilterUserProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterUserRule implements IProcessRule<FilterUserProcess> {

    @Override
    public void apply(FilterUserProcess process) {
        var pLogger = LogFactory.builder(FilterUserProcess.class, FilterUserRule.class);
        var query = process.Query();
        if (query.getParams().get("id") == null) {
            query.Field("id", "");
            query.Where().OrNotEmpty("id");
        }

        if (query.isEmpty()) {
            process.addLog(pLogger.WARNING("Filter User", "No filter properties set for user"));
            process.stop();
            return;
        }

        process.addLog(pLogger.INFO("Filter User", "Filtering by properties: " + query.getKeyPair()));

        var filterService = UserServiceFactory.FilterUser();
        var result = filterService.filter(query);

        process.setResult(result.getResult());

    }

}
