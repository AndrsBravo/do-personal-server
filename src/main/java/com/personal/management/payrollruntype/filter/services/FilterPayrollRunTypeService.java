package com.personal.management.payrollruntype.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.backoffice.user.entities.User;
import com.personal.management.payrollruntype.factories.PayrollRunTypeResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunTypeService implements IFilterService<TypeEntity> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollRunTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<TypeEntity>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunTypeResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_runs_types",
                "id", "prt_type", "prt_title", "prt_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(TypeEntity::new)
                .With(TypeEntity::setId, dbRow.column("id").getString())
                .With(TypeEntity::setType, dbRow.column("prt_type").getString())
                .With(TypeEntity::setTitle, dbRow.column("prt_title").getString())
                .With(TypeEntity::setDescription, dbRow.column("prt_description").getString())
                .With(TypeEntity::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(TypeEntity::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(TypeEntity::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollRunTypeResultFactory.FetchNull();
        }

        return PayrollRunTypeResultFactory.FetchResult(result);
    }
}
