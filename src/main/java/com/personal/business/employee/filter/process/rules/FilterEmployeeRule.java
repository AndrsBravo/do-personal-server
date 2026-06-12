package com.personal.business.employee.filter.process.rules;

import com.personal.business.employee.factories.EmployeeServiceFactory;
import com.personal.business.employee.filter.process.FilterEmployeeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterEmployeeRule implements IProcessRule<FilterEmployeeProcess> {

    @Override
    public void apply(FilterEmployeeProcess process) {

        var pLogger = LogFactory.builder(FilterEmployeeProcess.class, FilterEmployeeRule.class);
        var query = process.Query();

        var employeeFilterInput = process.getInitObject();

        if (employeeFilterInput.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (employeeFilterInput.getId() != null) {
            query.Field("id", employeeFilterInput.getId());
            query.Where().AndEqu("id");
        }

        if (employeeFilterInput.getBusiness() != null) {
            query.Field("business_id", employeeFilterInput.getBusiness().getId());
            query.Where().AndEqu("business_id");
        }

        if (employeeFilterInput.getName() != null) {
            query.Field("e_name", employeeFilterInput.getName());
            query.Where().AndEqu("e_name");
        }
        if (employeeFilterInput.getLastName() != null) {
            query.Field("e_last_name", employeeFilterInput.getLastName());
            query.Where().AndEqu("e_last_name");
        }

        var filterEmployee = EmployeeServiceFactory.FilterEmployee(employeeFilterInput.getBusiness().getDbName());

        var result = filterEmployee.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
