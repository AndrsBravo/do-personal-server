package com.personal.management.deduction.filter.process.rules;

import com.personal.management.deduction.factories.DeductionServiceFactory;
import com.personal.management.deduction.filter.process.FilterDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterDeductionRule implements IProcessRule<FilterDeductionProcess> {

    @Override
    public void apply(FilterDeductionProcess process) {

        var pLogger = LogFactory.builder(FilterDeductionProcess.class, FilterDeductionRule.class);
        var query = process.Query();
        var deductionFilter = process.getInitObject();
        if (deductionFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (deductionFilter.getId() != null) {
            query.Field("id", deductionFilter.getId());
            query.Where().AndEqu("id");
        }

        if (deductionFilter.getType() != null) {
            query.Field("bd_deduction", deductionFilter.getType());
            query.Where().AndEqu("bd_deduction");
        }

        var filterDeduction = DeductionServiceFactory.FilterDeduction();

        var result = filterDeduction.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
