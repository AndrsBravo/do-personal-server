package com.personal.business.employeebenefit.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.notifications.EmployeeBenefitNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeBenefitService extends FilterService<EmployeeBenefit> {

    public FilterEmployeeBenefitService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<EmployeeBenefit> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("employee_benefits",
                "id", "business_id", "business_benefits_id", "employees_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(EmployeeBenefit::new)
                    .With(EmployeeBenefit::setId, dbRow.column("id").getString())
                    .With(EmployeeBenefit::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(EmployeeBenefit::setBenefit, new Benefit(dbRow.column("business_benefits_id").getString()))
                    .With(EmployeeBenefit::setEmployee, new Employee(dbRow.column("employees_id").getString()))
                    .With(EmployeeBenefit::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(EmployeeBenefit::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(EmployeeBenefit::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(EmployeeBenefitNotificationFactory.FetchEmployeeBenefitSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(EmployeeBenefitNotificationFactory.FetchEmployeeBenefitFail());
        }

        return builder.get();
    }
}
