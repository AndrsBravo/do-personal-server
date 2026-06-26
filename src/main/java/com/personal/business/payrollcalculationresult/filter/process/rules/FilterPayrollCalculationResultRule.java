package com.personal.business.payrollcalculationresult.filter.process.rules;

import com.personal.business.payrollcalculationresult.factories.PayrollCalculationResultServiceFactory;
import com.personal.business.payrollcalculationresult.filter.process.FilterPayrollCalculationResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollCalculationResultRule implements IProcessRule<FilterPayrollCalculationResultProcess> {

    @Override
    public void apply(FilterPayrollCalculationResultProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollCalculationResultProcess.class, FilterPayrollCalculationResultRule.class);
        var query = process.Query();
        var payrollFilter = process.getInitObject();

        if (payrollFilter.getId() != null) {
            query.Field("id", payrollFilter.getId());
            query.Where().Field("id", payrollFilter.getId());
        }

        if (payrollFilter.getPayrollId() != null) {
            query.Field("payrolls_id", payrollFilter.getPayrollId());
            query.Where().AndEqu("payrolls_id");
        }

        var filterPayrollCalculationResult = PayrollCalculationResultServiceFactory.FilterPayrollCalculationResult(payrollFilter.getBusiness().getDbName());

        var result = filterPayrollCalculationResult.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
