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
        var initObject = process.getInitObject();

        if (initObject.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (initObject.getId() != null) {
            query.Field("id", initObject.getId());
            query.Where().AndEqu("id");
        }

        var filterBusiness = BusinessServiceFactory.FilterBusiness();

        var result = filterBusiness.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
