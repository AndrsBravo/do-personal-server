package com.personal.management.payrollrunbenefit.filter.process.rules;

import com.personal.management.payrollrunbenefit.factories.PayrollRunBenefitServiceFactory;
import com.personal.management.payrollrunbenefit.filter.process.FilterPayrollRunBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRunBenefitRule implements IProcessRule<FilterPayrollRunBenefitProcess> {

    @Override
    public void apply(FilterPayrollRunBenefitProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollRunBenefitProcess.class, FilterPayrollRunBenefitRule.class);
        var query = process.Query();
        var payrollRunBenefitFilter = process.getInitObject();

        if (payrollRunBenefitFilter.getId() != null) {
            query.Field("id", payrollRunBenefitFilter.getId());
            query.Where().Field("id", payrollRunBenefitFilter.getId());
        }

        if (payrollRunBenefitFilter.getBenefitId() != null) {
            query.Field("payroll_benefits_id", payrollRunBenefitFilter.getBenefitId());
            query.Where().AndEqu("payroll_benefits_id");
        }

        if (payrollRunBenefitFilter.getPayrollRunId() != null) {
            query.Field("payroll_runs_id", payrollRunBenefitFilter.getPayrollRunId());
            query.Where().AndEqu("payroll_runs_id");
        }

        var filterPayrollRunBenefit = PayrollRunBenefitServiceFactory.FilterPayrollRunBenefit();

        var result = filterPayrollRunBenefit.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
