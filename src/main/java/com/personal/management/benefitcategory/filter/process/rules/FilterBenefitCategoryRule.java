package com.personal.management.benefitcategory.filter.process.rules;

import com.personal.management.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.management.benefitcategory.filter.process.FilterBenefitCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBenefitCategoryRule implements IProcessRule<FilterBenefitCategoryProcess> {

    @Override
    public void apply(FilterBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterBenefitCategoryProcess.class, FilterBenefitCategoryRule.class);
        var query = process.Query();
        var benefitCategoryFilter = process.getInitObject();
        if (benefitCategoryFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (benefitCategoryFilter.getId() != null) {
            query.Field("id", benefitCategoryFilter.getId());
            query.Where().AndEqu("id");
        }

        if (benefitCategoryFilter.getType() != null) {
            query.Field("bc_category", benefitCategoryFilter.getType());
            query.Where().AndEqu("bc_category");
        }

        var filterBenefitCategory = BenefitCategoryServiceFactory.FilterBenefitCategory();

        var result = filterBenefitCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
