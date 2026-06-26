package com.personal.business.deduction.filter.process.rules;

import com.personal.business.deduction.factories.DeductionServiceFactory;
import com.personal.business.deduction.filter.process.FilterDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterDeductionRule implements IProcessRule<FilterDeductionProcess> {

    @Override
    public void apply(FilterDeductionProcess process) {

        var pLogger = LogFactory.builder(FilterDeductionProcess.class, FilterDeductionRule.class);
        var query = process.Query();

        var deductionFilterInput = process.getInitObject();

        if (deductionFilterInput.getId() != null) {
            query.Field("id", deductionFilterInput.getId());
            query.Where().Field("id", deductionFilterInput.getId());
        }

        if (deductionFilterInput.getType() != null) {
            query.Field("bd_deduction", deductionFilterInput.getType());
            query.Where().AndEqu("bd_deduction");
        }

        var filterDeduction = DeductionServiceFactory.FilterDeduction(deductionFilterInput.getBusiness().getDbName());

        var result = filterDeduction.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
