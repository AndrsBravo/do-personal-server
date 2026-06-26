package com.personal.management.financecategory.filter.process.rules;

import com.personal.management.financecategory.factories.FinanceCategoryServiceFactory;
import com.personal.management.financecategory.filter.process.FilterFinanceCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterFinanceCategoryRule implements IProcessRule<FilterFinanceCategoryProcess> {

    @Override
    public void apply(FilterFinanceCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterFinanceCategoryProcess.class, FilterFinanceCategoryRule.class);
        var query = process.Query();

        var financeCategoryFilter = process.getInitObject();

        if (financeCategoryFilter.getId() != null) {
            query.Field("id", financeCategoryFilter.getId());
            query.Where().Field("id", financeCategoryFilter.getId());
        }

        if (financeCategoryFilter.getType() != null) {
            query.Field("fc_category", financeCategoryFilter.getType());
            query.Where().AndEqu("fc_category");
        }

        var filterFinanceCategory = FinanceCategoryServiceFactory.FilterFinanceCategory();

        var result = filterFinanceCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
