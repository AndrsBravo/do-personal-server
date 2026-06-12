package com.personal.business.employeedeductionfeed.filter.process.rules;

import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedServiceFactory;
import com.personal.business.employeedeductionfeed.filter.process.FilterEmployeeDeductionFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterEmployeeDeductionFeedRule implements IProcessRule<FilterEmployeeDeductionFeedProcess> {

    @Override
    public void apply(FilterEmployeeDeductionFeedProcess process) {

        var pLogger = LogFactory.builder(FilterEmployeeDeductionFeedProcess.class, FilterEmployeeDeductionFeedRule.class);
        var query = process.Query();
        var employeeDeductionFeedFilter = process.getInitObject();
        if (employeeDeductionFeedFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (employeeDeductionFeedFilter.getId() != null) {
            query.Field("id", employeeDeductionFeedFilter.getId());
            query.Where().AndEqu("id");
        }

        if (employeeDeductionFeedFilter.getDeductionId() != null) {
            query.Field("business_deductions_id", employeeDeductionFeedFilter.getDeductionId());
            query.Where().AndEqu("business_deductions_id");
        }

        if (employeeDeductionFeedFilter.getEmployeeId() != null) {
            query.Field("employee_deduction_id", employeeDeductionFeedFilter.getEmployeeId());
            query.Where().AndEqu("employee_deduction_id");
        }

        var filterEmployeeDeductionFeed = EmployeeDeductionFeedServiceFactory.FilterEmployeeDeductionFeed(employeeDeductionFeedFilter.getBusiness().getDbName());

        var result = filterEmployeeDeductionFeed.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
