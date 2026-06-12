package com.personal.business.benefitcategory.filter.process.rules;

import com.personal.business.benefitcategory.factories.BenefitCategoryServiceFactory;
import com.personal.business.benefitcategory.filter.process.FilterBenefitCategoryProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBenefitCategoryRule implements IProcessRule<FilterBenefitCategoryProcess> {

    @Override
    public void apply(FilterBenefitCategoryProcess process) {

        var pLogger = LogFactory.builder(FilterBenefitCategoryProcess.class, FilterBenefitCategoryRule.class);

        var query = process.Query();
        var benefitCategory = process.getInitObject();

        if (benefitCategory.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (benefitCategory.getId() != null) {
            query.Field("id", benefitCategory.getId());
            query.Where().AndEqu("id");
        }

        if (benefitCategory.getType() != null) {
            query.Field("bc_category", benefitCategory.getType());
            query.Where().AndEqu("bc_category");
        }

        var filterBenefitCategory = BenefitCategoryServiceFactory.FilterBenefitCategory(benefitCategory.getBusiness().getDbName());

        var result = filterBenefitCategory.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
