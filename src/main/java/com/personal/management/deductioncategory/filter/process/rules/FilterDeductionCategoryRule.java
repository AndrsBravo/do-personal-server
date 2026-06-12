package com.personal.management.deductioncategory.filter.process.rules;

import com.personal.management.deductioncategory.factories.DeductionCategoryServiceFactory;
import com.personal.management.deductioncategory.filter.process.FilterDeductionCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterDeductionCategoryRule implements IProcessRule<FilterDeductionCategoryProcess> {

    @Override
    public void apply(FilterDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterDeductionCategoryProcess.class, FilterDeductionCategoryRule.class);
        var query = process.Query();

        var deductionCategoryFilter = process.getInitObject();

        if (deductionCategoryFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (deductionCategoryFilter.getId() != null) {
            query.Field("id", deductionCategoryFilter.getId());
            query.Where().AndEqu("id");
        }

        if (deductionCategoryFilter.getType() != null) {
            query.Field("dc_category", deductionCategoryFilter.getType());
            query.Where().AndEqu("dc_category");
        }

        var filterDeductionCategory = DeductionCategoryServiceFactory.FilterDeductionCategory();

        var result = filterDeductionCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
