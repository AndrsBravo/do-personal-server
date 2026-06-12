package com.personal.business.payrollrunresult.filter.process.rules;

import com.personal.business.payrollrunresult.factories.PayrollRunResultServiceFactory;
import com.personal.business.payrollrunresult.filter.process.FilterPayrollRunResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRunResultRule implements IProcessRule<FilterPayrollRunResultProcess> {

    @Override
    public void apply(FilterPayrollRunResultProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollRunResultProcess.class, FilterPayrollRunResultRule.class);
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

        if (payrollFilter.getPayrollId() != null) {
            query.Field("payrolls_id", payrollFilter.getPayrollId());
            query.Where().AndEqu("payrolls_id");
        }

        var filterPayrollRunResult = PayrollRunResultServiceFactory.FilterPayrollRunResult(payrollFilter.getBusiness().getDbName());

        var result = filterPayrollRunResult.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter Payroll Run Results", "Filtered payroll run results with properties: " + query.getKeyPair()));
    }

}
