package com.personal.business.payroll.filter.process.rules;

import com.personal.business.payroll.factories.PayrollServiceFactory;
import com.personal.business.payroll.filter.process.FilterPayrollProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRule implements IProcessRule<FilterPayrollProcess> {

    @Override
    public void apply(FilterPayrollProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollProcess.class, FilterPayrollRule.class);
        var query = process.Query();

        var payrollFilterInput = process.getInitObject();

        if (payrollFilterInput.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (payrollFilterInput.getId() != null) {
            query.Field("id", payrollFilterInput.getId());
            query.Where().AndEqu("id");
        }

        if (payrollFilterInput.getType() != null) {
            query.Field("pr_payroll", payrollFilterInput.getType());
            query.Where().AndEqu("pr_payroll");
        }

        var filterPayroll = PayrollServiceFactory.FilterPayroll(payrollFilterInput.getBusiness().getDbName());

        var result = filterPayroll.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
