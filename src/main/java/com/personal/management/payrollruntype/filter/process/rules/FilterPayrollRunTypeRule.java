package com.personal.management.payrollruntype.filter.process.rules;

import com.personal.management.payrollruntype.factories.PayrollRunTypeServiceFactory;
import com.personal.management.payrollruntype.filter.process.FilterPayrollRunTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRunTypeRule implements IProcessRule<FilterPayrollRunTypeProcess> {

    @Override
    public void apply(FilterPayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollRunTypeProcess.class, FilterPayrollRunTypeRule.class);
        var query = process.Query();
        var payrollRunTypeFilter = process.getInitObject();

        if (payrollRunTypeFilter.getId() != null) {
            query.Field("id", payrollRunTypeFilter.getId());
            query.Where().Field("id", payrollRunTypeFilter.getId());
        }

        if (payrollRunTypeFilter.getType() != null) {
            query.Field("prt_type", payrollRunTypeFilter.getType());
            query.Where().AndEqu("prt_type");
        }

        var filterPayrollRunType = PayrollRunTypeServiceFactory.FilterPayrollRunType();

        var result = filterPayrollRunType.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
