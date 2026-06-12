package com.personal.business.employeebenefit.filter.process.rules;

import com.personal.business.employeebenefit.factories.EmployeeBenefitServiceFactory;
import com.personal.business.employeebenefit.filter.process.FilterEmployeeBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterEmployeeBenefitRule implements IProcessRule<FilterEmployeeBenefitProcess> {

    @Override
    public void apply(FilterEmployeeBenefitProcess process) {

        var pLogger = LogFactory.builder(FilterEmployeeBenefitProcess.class, FilterEmployeeBenefitRule.class);
        var query = process.Query();
        var employeeBenefitFilter = process.getInitObject();
        if (employeeBenefitFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (employeeBenefitFilter.getId() != null) {
            query.Field("id", employeeBenefitFilter.getId());
            query.Where().AndEqu("id");
        }
        if (employeeBenefitFilter.getBusiness() != null) {
            query.Field("business_id", employeeBenefitFilter.getBusiness().getId());
            query.Where().AndEqu("id");
        }

        if (employeeBenefitFilter.getBenefitId() != null) {
            query.Field("business_benefits_id", employeeBenefitFilter.getBenefitId());
            query.Where().AndEqu("business_benefits_id");
        }

        if (employeeBenefitFilter.getEmployeeId() != null) {
            query.Field("employees_id", employeeBenefitFilter.getEmployeeId());
            query.Where().AndEqu("employees_id");
        }

        var filterEmployeeBenefit = EmployeeBenefitServiceFactory.FilterEmployeeBenefit(employeeBenefitFilter.getBusiness().getDbName());

        var result = filterEmployeeBenefit.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
