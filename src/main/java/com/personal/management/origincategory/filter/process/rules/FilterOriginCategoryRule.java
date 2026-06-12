package com.personal.management.origincategory.filter.process.rules;

import com.personal.management.origincategory.factories.OriginCategoryServiceFactory;
import com.personal.management.origincategory.filter.process.FilterOriginCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterOriginCategoryRule implements IProcessRule<FilterOriginCategoryProcess> {

    @Override
    public void apply(FilterOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterOriginCategoryProcess.class, FilterOriginCategoryRule.class);
        var query = process.Query();
        var originCategoryFilter = process.getInitObject();

        if (originCategoryFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (originCategoryFilter.getId() != null) {
            query.Field("id", originCategoryFilter.getId());
            query.Where().AndEqu("id");
        }

        if (originCategoryFilter.getType() != null) {
            query.Field("oc_origin", originCategoryFilter.getType());
            query.Where().AndEqu("oc_origin");
        }

        var filterOriginCategory = OriginCategoryServiceFactory.FilterOriginCategory();

        var result = filterOriginCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
