package com.personal.business.payrollemployee.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.employee.entities.Employee;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollemployee.entities.PayrollEmployee;
import com.personal.business.payrollemployee.notifications.PayrollEmployeeNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollEmployeeService extends FilterService<PayrollEmployee> {

    public FilterPayrollEmployeeService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollEmployee> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_employee",
                "id", "business_id", "employees_id", "payrolls_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(PayrollEmployee::new)
                    .With(PayrollEmployee::setId, dbRow.column("id").getString())
                    .With(PayrollEmployee::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(PayrollEmployee::setEmployee, new Employee(dbRow.column("employees_id").getString()))
                    .With(PayrollEmployee::setPayroll, new Payroll(dbRow.column("payrolls_id").getString()))
                    .With(PayrollEmployee::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollEmployee::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollEmployee::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollEmployeeNotificationFactory.FetchPayrollEmployeeSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollEmployeeNotificationFactory.FetchPayrollEmployeeFail());
        }

        return builder.get();
    }
}
