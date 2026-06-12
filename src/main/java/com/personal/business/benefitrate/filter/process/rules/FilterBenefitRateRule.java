package com.personal.business.benefitrate.filter.process.rules;

import com.personal.business.benefitrate.factories.BenefitRateServiceFactory;
import com.personal.business.benefitrate.filter.process.FilterBenefitRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBenefitRateRule implements IProcessRule<FilterBenefitRateProcess> {

    @Override
    public void apply(FilterBenefitRateProcess process) {

        var pLogger = LogFactory.builder(FilterBenefitRateProcess.class, FilterBenefitRateRule.class);
        var query = process.Query();
        var benefitRateFilter = process.getInitObject();
        if (benefitRateFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (benefitRateFilter.getId() != null) {
            query.Field("id", benefitRateFilter.getId());
            query.Where().AndEqu("id");
        }

        if (benefitRateFilter.getType() != null) {
            query.Field("business_benefit_id", benefitRateFilter.getType());
            query.Where().AndEqu("business_benefit_id");
        }

        var filterBenefitRate = BenefitRateServiceFactory.FilterBenefitRate(benefitRateFilter.getBusiness().getDbName());

        var result = filterBenefitRate.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
