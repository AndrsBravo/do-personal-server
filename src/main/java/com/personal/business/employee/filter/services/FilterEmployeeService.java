package com.personal.business.employee.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.factories.EmployeeResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeService implements IFilterService<Employee> {

    private final Optional<DbClient> dbClient;

    public FilterEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Employee>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeResultFactory.FetchNull();
        }

        var queryString = query.Select("employees",
                "id", "e_name", "e_last_name", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(Employee::new)
                .With(Employee::setId, dbRow.column("id").getString())
                .With(Employee::setName, dbRow.column("e_name").getString())
                .With(Employee::setLastName, dbRow.column("e_last_name").getString())
                .With(Employee::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(Employee::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(Employee::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return EmployeeResultFactory.FetchNull();
        }

        return EmployeeResultFactory.FetchResult(result);
    }
}
