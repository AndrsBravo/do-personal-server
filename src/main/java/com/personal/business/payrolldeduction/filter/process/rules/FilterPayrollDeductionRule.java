package com.personal.business.payrolldeduction.filter.process.rules;

import com.personal.business.payrolldeduction.factories.PayrollDeductionServiceFactory;
import com.personal.business.payrolldeduction.filter.process.FilterPayrollDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollDeductionRule implements IProcessRule<FilterPayrollDeductionProcess> {

    @Override
    public void apply(FilterPayrollDeductionProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollDeductionProcess.class, FilterPayrollDeductionRule.class);
        var query = process.Query();
        var payrollDeductionFilter = process.getInitObject();
        if (payrollDeductionFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (payrollDeductionFilter.getId() != null) {
            query.Field("id", payrollDeductionFilter.getId());
            query.Where().AndEqu("id");
        }

        if (payrollDeductionFilter.getDeductionId() != null) {
            query.Field("business_deductions_id", payrollDeductionFilter.getDeductionId());
            query.Where().AndEqu("business_deductions_id");
        }

        if (payrollDeductionFilter.getPayrollId() != null) {
            query.Field("payrolls_id", payrollDeductionFilter.getPayrollId());
            query.Where().AndEqu("payrolls_id");
        }

        var filterPayrollDeduction = PayrollDeductionServiceFactory.FilterPayrollDeduction(payrollDeductionFilter.getBusiness().getDbName());

        var result = filterPayrollDeduction.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
