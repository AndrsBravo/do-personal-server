package com.personal.management.deductionrate.filter.process.rules;

import com.personal.management.deductionrate.factories.DeductionRateServiceFactory;
import com.personal.management.deductionrate.filter.process.FilterDeductionRateProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterDeductionRateRule implements IProcessRule<FilterDeductionRateProcess> {

    @Override
    public void apply(FilterDeductionRateProcess process) {

        var pLogger = LogFactory.builder(FilterDeductionRateProcess.class, FilterDeductionRateRule.class);
        var query = process.Query();

        var deductionRateFilter = process.getInitObject();

        if (deductionRateFilter.getId() != null) {
            query.Field("id", deductionRateFilter.getId());
            query.Where().Field("id", deductionRateFilter.getId());
        }

        if (deductionRateFilter.getType() != null) {
            query.Field("business_deduction_id", deductionRateFilter.getType());
            query.Where().AndEqu("business_deduction_id");
        }

        var filterDeductionRate = DeductionRateServiceFactory.FilterDeductionRate();

        var result = filterDeductionRate.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
