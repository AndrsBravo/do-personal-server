package com.personal.business.employeededuction.filter.process.rules;

import com.personal.business.employeededuction.factories.EmployeeDeductionServiceFactory;
import com.personal.business.employeededuction.filter.process.FilterEmployeeDeductionProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterEmployeeDeductionRule implements IProcessRule<FilterEmployeeDeductionProcess> {

    @Override
    public void apply(FilterEmployeeDeductionProcess process) {

        var pLogger = LogFactory.builder(FilterEmployeeDeductionProcess.class, FilterEmployeeDeductionRule.class);
        var query = process.Query();
        var employeeDeductionFilter = process.getInitObject();
        if (employeeDeductionFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (employeeDeductionFilter.getId() != null) {
            query.Field("id", employeeDeductionFilter.getId());
            query.Where().AndEqu("id");
        }
        if (employeeDeductionFilter.getBusiness() != null) {
            query.Field("business_id", employeeDeductionFilter.getBusiness().getId());
            query.Where().AndEqu("id");
        }

        if (employeeDeductionFilter.getDeductionId() != null) {
            query.Field("business_deductions_id", employeeDeductionFilter.getDeductionId());
            query.Where().AndEqu("business_deductions_id");
        }

        if (employeeDeductionFilter.getEmployeeId() != null) {
            query.Field("employees_id", employeeDeductionFilter.getEmployeeId());
            query.Where().AndEqu("employees_id");
        }

        var filterEmployeeDeduction = EmployeeDeductionServiceFactory.FilterEmployeeDeduction(employeeDeductionFilter.getBusiness().getDbName());

        var result = filterEmployeeDeduction.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
