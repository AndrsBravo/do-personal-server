package com.personal.management.benefit.filter.process.rules;

import com.personal.management.benefit.factories.BenefitServiceFactory;
import com.personal.management.benefit.filter.process.FilterBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBenefitRule implements IProcessRule<FilterBenefitProcess> {

    @Override
    public void apply(FilterBenefitProcess process) {

        var pLogger = LogFactory.builder(FilterBenefitProcess.class, FilterBenefitRule.class);
        var query = process.Query();
        var benefitFilter = process.getInitObject();
        if (benefitFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (benefitFilter.getId() != null) {
            query.Field("id", benefitFilter.getId());
            query.Where().AndEqu("id");
        }

        if (benefitFilter.getType() != null) {
            query.Field("bb_benefit", benefitFilter.getType());
            query.Where().AndEqu("bb_benefit");
        }

        var filterBenefit = BenefitServiceFactory.FilterBenefit();

        var result = filterBenefit.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
