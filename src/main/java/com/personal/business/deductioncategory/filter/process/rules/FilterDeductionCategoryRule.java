package com.personal.business.deductioncategory.filter.process.rules;

import com.personal.business.deductioncategory.factories.DeductionCategoryServiceFactory;
import com.personal.business.deductioncategory.filter.process.FilterDeductionCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterDeductionCategoryRule implements IProcessRule<FilterDeductionCategoryProcess> {

    @Override
    public void apply(FilterDeductionCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterDeductionCategoryProcess.class, FilterDeductionCategoryRule.class);

        var query = process.Query();
        var deductionCategory = process.getInitObject();

        if (deductionCategory.getId() != null) {
            query.Field("id", deductionCategory.getId());
            query.Where().Field("id", deductionCategory.getId());
        }

        if (deductionCategory.getType() != null) {
            query.Field("dc_category", deductionCategory.getType());
            query.Where().AndEqu("dc_category");
        }

        var filterDeductionCategory = DeductionCategoryServiceFactory.FilterDeductionCategory(deductionCategory.getBusiness().getDbName());

        var result = filterDeductionCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
