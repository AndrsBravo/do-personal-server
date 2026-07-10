package com.personal.business.employeescale.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.factories.EmployeeScaleResultFactory;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeScaleService implements IFilterService<EmployeeScale> {

    private final Optional<DbClient> dbClient;

    public FilterEmployeeScaleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<EmployeeScale>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeScaleResultFactory.FetchNull();
        }

        var queryString = query.Select("employee_scale",
                "id", "business_id", "employees_id", "business_hierarchy_id", "es_ended_at", "es_started_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(EmployeeScale::new)
                .With(EmployeeScale::setId, dbRow.column("id").getString())
                .With(EmployeeScale::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(EmployeeScale::setEmployee, new Employee(dbRow.column("employees_id").getString()))
                .With(EmployeeScale::setHierarchy, new Hierarchy(dbRow.column("business_hierarchy_id").getString()))
                .With(EmployeeScale::setStartedAt, dbRow.column("es_started_at").get(LocalDateTime.class))
                .With(EmployeeScale::setEndedAt, dbRow.column("es_ended_at").get(LocalDateTime.class))
                .With(EmployeeScale::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(EmployeeScale::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(EmployeeScale::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return EmployeeScaleResultFactory.FetchNull();
        }

        return EmployeeScaleResultFactory.FetchResult(result);
    }
}
