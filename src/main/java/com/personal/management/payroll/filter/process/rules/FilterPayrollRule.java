package com.personal.management.payroll.filter.process.rules;

import com.personal.management.payroll.factories.PayrollServiceFactory;
import com.personal.management.payroll.filter.process.FilterPayrollProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRule implements IProcessRule<FilterPayrollProcess> {

    @Override
    public void apply(FilterPayrollProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollProcess.class, FilterPayrollRule.class);
        var query = process.Query();
        var payrollFilter = process.getInitObject();

        if (payrollFilter.getId() != null) {
            query.Field("id", payrollFilter.getId());
            query.Where().Field("id", payrollFilter.getId());
        }

        if (payrollFilter.getType() != null) {
            query.Field("pr_payroll", payrollFilter.getType());
            query.Where().AndEqu("pr_payroll");
        }

        var filterPayroll = PayrollServiceFactory.FilterPayroll();

        var result = filterPayroll.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
