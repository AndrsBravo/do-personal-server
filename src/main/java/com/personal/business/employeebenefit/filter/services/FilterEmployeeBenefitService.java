package com.personal.business.employeebenefit.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.factories.EmployeeBenefitResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeBenefitService implements IFilterService<EmployeeBenefit> {

    private final Optional<DbClient> dbClient;

    public FilterEmployeeBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<EmployeeBenefit>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeBenefitResultFactory.FetchNull();
        }

        var queryString = query.Select("employee_benefits",
                "id", "business_id", "business_benefits_id", "employees_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
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
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return EmployeeBenefitResultFactory.FetchNull();
        }

        return EmployeeBenefitResultFactory.FetchResult(result);
    }
}
