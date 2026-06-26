package com.personal.business.payrollruntype.filter.process.rules;

import com.personal.business.payrollruntype.factories.PayrollRunTypeServiceFactory;
import com.personal.business.payrollruntype.filter.process.FilterPayrollRunTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollRunTypeRule implements IProcessRule<FilterPayrollRunTypeProcess> {

    @Override
    public void apply(FilterPayrollRunTypeProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollRunTypeProcess.class, FilterPayrollRunTypeRule.class);

        var query = process.Query();

        var payRollRunType = process.getInitObject();

        if (payRollRunType.getId() != null) {
            query.Field("id", payRollRunType.getId());
            query.Where().Field("id", payRollRunType.getId());
        }

        if (payRollRunType.getType() != null) {
            query.Field("prt_type", payRollRunType.getType());
            query.Where().AndEqu("prt_type");
        }

        var filterPayrollRunType = PayrollRunTypeServiceFactory.FilterPayrollRunType(payRollRunType.getBusiness().getDbName());

        var result = filterPayrollRunType.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
