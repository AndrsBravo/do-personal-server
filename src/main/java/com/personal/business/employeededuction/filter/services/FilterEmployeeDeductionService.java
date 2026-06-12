package com.personal.business.employeededuction.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.factories.EmployeeDeductionResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeDeductionService implements IFilterService<EmployeeDeduction> {

    private final Optional<DbClient> dbClient;

    public FilterEmployeeDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<EmployeeDeduction>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeDeductionResultFactory.FetchNull();
        }

        var queryString = query.Select("employee_deductions",
                "id", "business_id", "business_deductions_id", "employees_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var employeeDeduction = new EmployeeDeduction();
                    employeeDeduction.setId(dbRow.column("id").getString());
                    employeeDeduction.setBusiness(new Business(dbRow.column("business_id").getString()));
                    employeeDeduction.setDeduction(new Deduction(dbRow.column("business_deductions_id").getString()));
                    employeeDeduction.setEmployee(new Employee(dbRow.column("employees_id").getString()));
                    employeeDeduction.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    employeeDeduction.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    employeeDeduction.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return employeeDeduction;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return EmployeeDeductionResultFactory.FetchNull();
        }

        return EmployeeDeductionResultFactory.FetchResult(result);
    }
}
