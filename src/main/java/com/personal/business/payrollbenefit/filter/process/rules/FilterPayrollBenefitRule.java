package com.personal.business.payrollbenefit.filter.process.rules;

import com.personal.business.payrollbenefit.factories.PayrollBenefitServiceFactory;
import com.personal.business.payrollbenefit.filter.process.FilterPayrollBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollBenefitRule implements IProcessRule<FilterPayrollBenefitProcess> {

    @Override
    public void apply(FilterPayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollBenefitProcess.class, FilterPayrollBenefitRule.class);
        var query = process.Query();
        var payrollBenefitFilter = process.getInitObject();
        if (payrollBenefitFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (payrollBenefitFilter.getId() != null) {
            query.Field("id", payrollBenefitFilter.getId());
            query.Where().AndEqu("id");
        }

        if (payrollBenefitFilter.getBenefitId() != null) {
            query.Field("business_benefits_id", payrollBenefitFilter.getBenefitId());
            query.Where().AndEqu("business_benefits_id");
        }

        if (payrollBenefitFilter.getPayrollId() != null) {
            query.Field("payrolls_id", payrollBenefitFilter.getPayrollId());
            query.Where().AndEqu("payrolls_id");
        }

        var filterPayrollBenefit = PayrollBenefitServiceFactory.FilterPayrollBenefit(payrollBenefitFilter.getBusiness().getDbName());

        var result = filterPayrollBenefit.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
