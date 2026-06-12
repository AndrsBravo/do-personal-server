package com.personal.business.payrollrun.filter.process.rules;

import com.personal.business.payrollrun.factories.PayrollRunServiceFactory;
import com.personal.business.payrollrun.filter.process.FilterPayrollRunProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRunRule implements IProcessRule<FilterPayrollRunProcess> {

    @Override
    public void apply(FilterPayrollRunProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollRunProcess.class, FilterPayrollRunRule.class);
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

        var filterPayrollRun = PayrollRunServiceFactory.FilterPayrollRun(payrollFilter.getBusiness().getDbName());

        var result = filterPayrollRun.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
