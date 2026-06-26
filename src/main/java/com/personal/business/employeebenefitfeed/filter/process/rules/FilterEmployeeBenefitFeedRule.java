package com.personal.business.employeebenefitfeed.filter.process.rules;

import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedServiceFactory;
import com.personal.business.employeebenefitfeed.filter.process.FilterEmployeeBenefitFeedProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterEmployeeBenefitFeedRule implements IProcessRule<FilterEmployeeBenefitFeedProcess> {

    @Override
    public void apply(FilterEmployeeBenefitFeedProcess process) {

        var pLogger = LogFactory.builder(FilterEmployeeBenefitFeedProcess.class, FilterEmployeeBenefitFeedRule.class);
        var query = process.Query();
        var employeeBenefitFeedFilter = process.getInitObject();

        if (employeeBenefitFeedFilter.getId() != null) {
            query.Field("id", employeeBenefitFeedFilter.getId());
            query.Where().Field("id", employeeBenefitFeedFilter.getId());
        }

        if (employeeBenefitFeedFilter.getBenefitId() != null) {
            query.Field("business_benefits_id", employeeBenefitFeedFilter.getBenefitId());
            query.Where().AndEqu("business_benefits_id");
        }

        if (employeeBenefitFeedFilter.getEmployeeId() != null) {
            query.Field("employee_benefit_id", employeeBenefitFeedFilter.getEmployeeId());
            query.Where().AndEqu("employee_benefit_id");
        }

        var filterEmployeeBenefitFeed = EmployeeBenefitFeedServiceFactory.FilterEmployeeBenefitFeed(employeeBenefitFeedFilter.getBusiness().getDbName());

        var result = filterEmployeeBenefitFeed.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
