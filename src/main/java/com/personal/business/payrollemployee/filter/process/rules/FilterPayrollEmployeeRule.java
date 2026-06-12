package com.personal.business.payrollemployee.filter.process.rules;

import com.personal.business.payrollemployee.factories.PayrollEmployeeServiceFactory;
import com.personal.business.payrollemployee.filter.process.FilterPayrollEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterPayrollEmployeeRule implements IProcessRule<FilterPayrollEmployeeProcess> {

    @Override
    public void apply(FilterPayrollEmployeeProcess process) {

        var pLogger = LogFactory.builder(FilterPayrollEmployeeProcess.class, FilterPayrollEmployeeRule.class);
        var query = process.Query();
        var payrollEmployeeFilter = process.getInitObject();

        if (payrollEmployeeFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (payrollEmployeeFilter.getId() != null) {
            query.Field("id", payrollEmployeeFilter.getId());
            query.Where().AndEqu("id");
        }
        if (payrollEmployeeFilter.getBusiness() != null) {
            query.Field("business_id", payrollEmployeeFilter.getBusiness().getId());
            query.Where().AndEqu("business_id");
        }

        if (payrollEmployeeFilter.getEmployeeId() != null) {
            query.Field("employees_id", payrollEmployeeFilter.getEmployeeId());
            query.Where().AndEqu("employees_id");
        }

        if (payrollEmployeeFilter.getPayrollId() != null) {
            query.Field("payrolls_id", payrollEmployeeFilter.getPayrollId());
            query.Where().AndEqu("payrolls_id");
        }

        var filterPayrollEmployee = PayrollEmployeeServiceFactory.FilterPayrollEmployee(payrollEmployeeFilter.getBusiness().getDbName());

        var result = filterPayrollEmployee.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
