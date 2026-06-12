package com.personal.business.origincategory.filter.process.rules;

import com.personal.business.origincategory.factories.OriginCategoryServiceFactory;
import com.personal.business.origincategory.filter.process.FilterOriginCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterOriginCategoryRule implements IProcessRule<FilterOriginCategoryProcess> {

    @Override
    public void apply(FilterOriginCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterOriginCategoryProcess.class, FilterOriginCategoryRule.class);

        var query = process.Query();
        var originCategory = process.getInitObject();

        if (originCategory.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (originCategory.getId() != null) {
            query.Field("id", originCategory.getId());
            query.Where().AndEqu("id");
        }

        if (originCategory.getType() != null) {
            query.Field("oc_origin", originCategory.getType());
            query.Where().AndEqu("oc_origin");
        }

        var filterOriginCategory = OriginCategoryServiceFactory.FilterOriginCategory(originCategory.getBusiness().getDbName());

        var result = filterOriginCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
