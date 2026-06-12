package com.personal.business.benefit.filter.process.rules;

import com.personal.business.benefit.factories.BenefitServiceFactory;
import com.personal.business.benefit.filter.process.FilterBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBenefitRule implements IProcessRule<FilterBenefitProcess> {

    @Override
    public void apply(FilterBenefitProcess process) {

        var pLogger = LogFactory.builder(FilterBenefitProcess.class, FilterBenefitRule.class);
        var query = process.Query();

        var benefitFilterInput = process.getInitObject();

        if (benefitFilterInput.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (benefitFilterInput.getId() != null) {
            query.Field("id", benefitFilterInput.getId());
            query.Where().AndEqu("id");
        }

        if (benefitFilterInput.getType() != null) {
            query.Field("bb_benefit", benefitFilterInput.getType());
            query.Where().AndEqu("bb_benefit");
        }

        var filterBenefit = BenefitServiceFactory.FilterBenefit(benefitFilterInput.getBusiness().getDbName());

        var result = filterBenefit.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
