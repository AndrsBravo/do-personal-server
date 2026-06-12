package com.personal.business.payrollcalculation.filter.process.rules;

import com.personal.business.payrollcalculation.factories.PayrollCalculationServiceFactory;
import com.personal.business.payrollcalculation.filter.process.FilterPayrollCalculationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollCalculationRule implements IProcessRule<FilterPayrollCalculationProcess> {

    @Override
    public void apply(FilterPayrollCalculationProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollCalculationProcess.class, FilterPayrollCalculationRule.class);
        var query = process.Query();
        var payrollFilter = process.getInitObject();
        if (payrollFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (payrollFilter.getId() != null) {
            query.Field("id", payrollFilter.getId());
            query.Where().AndEqu("id");
        }

        if (payrollFilter.getType() != null) {
            query.Field("payrolls_id", payrollFilter.getType());
            query.Where().AndEqu("payrolls_id");
        }

        var filterPayrollCalculation = PayrollCalculationServiceFactory.FilterPayrollCalculation(payrollFilter.getBusiness().getDbName());

        var result = filterPayrollCalculation.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
