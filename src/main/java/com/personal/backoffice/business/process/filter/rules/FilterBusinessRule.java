package com.personal.backoffice.business.process.filter.rules;

import com.personal.backoffice.business.factories.BusinessServiceFactory;
import com.personal.backoffice.business.process.filter.FilterBusinessProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBusinessRule implements IProcessRule<FilterBusinessProcess> {

    @Override
    public void apply(FilterBusinessProcess process) {

        var pLogger = LogFactory.builder(FilterBusinessProcess.class, FilterBusinessRule.class);
        var query = process.Query();
        var business = process.getInitObject();

        if (business.getId() != null) {
            query.Field("id", business.getId());
            query.Where().Field("id", business.getId());
        }

        var filterBusiness = BusinessServiceFactory.FilterBusiness();

        var result = filterBusiness.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
