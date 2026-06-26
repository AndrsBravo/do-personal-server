package com.personal.business.employeescale.filter.process.rules;

import com.personal.business.employeescale.factories.EmployeeScaleServiceFactory;
import com.personal.business.employeescale.filter.process.FilterEmployeeScaleProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterEmployeeScaleRule implements IProcessRule<FilterEmployeeScaleProcess> {

    @Override
    public void apply(FilterEmployeeScaleProcess process) {

        var pLogger = LogFactory.builder(FilterEmployeeScaleProcess.class, FilterEmployeeScaleRule.class);
        var query = process.Query();
        var employeeScaleFilter = process.getInitObject();

       
        if (employeeScaleFilter.getId() != null) {
            query.Field("id", employeeScaleFilter.getId());
            query.Where().Field("id", employeeScaleFilter.getId());
        }
        if (employeeScaleFilter.getBusiness() != null) {
            query.Field("business_id", employeeScaleFilter.getBusiness().getId());
            query.Where().AndEqu("business_id");
        }

        if (employeeScaleFilter.getEmployeeId() != null) {
            query.Field("employees_id", employeeScaleFilter.getEmployeeId());
            query.Where().AndEqu("employees_id");
        }

        if (employeeScaleFilter.getHierarchyId() != null) {
            query.Field("business_hierarchy_id", employeeScaleFilter.getHierarchyId());
            query.Where().AndEqu("business_hierarchy_id");
        }

        var filterEmployeeScale = EmployeeScaleServiceFactory.FilterEmployeeScale(employeeScaleFilter.getBusiness().getDbName());

        var result = filterEmployeeScale.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
