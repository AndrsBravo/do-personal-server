package com.personal.business.employeededuction.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.notifications.EmployeeDeductionNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeDeductionService extends FilterService<EmployeeDeduction> {

    public FilterEmployeeDeductionService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<EmployeeDeduction> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("employee_deductions",
                "id", "business_id", "business_deductions_id", "employees_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(EmployeeDeduction::new)
                    .With(EmployeeDeduction::setId, dbRow.column("id").getString())
                    .With(EmployeeDeduction::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(EmployeeDeduction::setDeduction, new Deduction(dbRow.column("business_deductions_id").getString()))
                    .With(EmployeeDeduction::setEmployee, new Employee(dbRow.column("employees_id").getString()))
                    .With(EmployeeDeduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(EmployeeDeduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(EmployeeDeduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(EmployeeDeductionNotificationFactory.FetchEmployeeDeductionSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(EmployeeDeductionNotificationFactory.FetchEmployeeDeductionFail());
        }

        return builder.get();
    }
}
