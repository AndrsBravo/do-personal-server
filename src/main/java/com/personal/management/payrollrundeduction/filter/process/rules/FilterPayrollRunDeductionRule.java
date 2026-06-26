package com.personal.management.payrollrundeduction.filter.process.rules;

import com.personal.management.payrollrundeduction.factories.PayrollRunDeductionServiceFactory;
import com.personal.management.payrollrundeduction.filter.process.FilterPayrollRunDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRunDeductionRule implements IProcessRule<FilterPayrollRunDeductionProcess> {

    @Override
    public void apply(FilterPayrollRunDeductionProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollRunDeductionProcess.class, FilterPayrollRunDeductionRule.class);
        var query = process.Query();
        var payrollRunDeductionFilter = process.getInitObject();

        if (payrollRunDeductionFilter.getId() != null) {
            query.Field("id", payrollRunDeductionFilter.getId());
            query.Where().Field("id", payrollRunDeductionFilter.getId());
        }

        if (payrollRunDeductionFilter.getDeductionId() != null) {
            query.Field("payroll_deductions_id", payrollRunDeductionFilter.getDeductionId());
            query.Where().AndEqu("payroll_deductions_id");
        }

        if (payrollRunDeductionFilter.getPayrollRunId() != null) {
            query.Field("payroll_runs_id", payrollRunDeductionFilter.getPayrollRunId());
            query.Where().AndEqu("payroll_runs_id");
        }

        var filterPayrollRunDeduction = PayrollRunDeductionServiceFactory.FilterPayrollRunDeduction();

        var result = filterPayrollRunDeduction.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
