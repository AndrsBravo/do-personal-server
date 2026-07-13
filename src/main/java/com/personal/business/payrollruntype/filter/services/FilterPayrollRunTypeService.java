package com.personal.business.payrollruntype.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.payrollruntype.notifications.PayrollRunTypeNotificationFactory;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunTypeService extends FilterService<TypeEntity> {

    public FilterPayrollRunTypeService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<TypeEntity> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_runs_types",
                "id", "prt_type", "prt_title", "prt_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
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

            builder.withResult(result)
                    .withNotification(PayrollRunTypeNotificationFactory.FetchPayrollRunTypeSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollRunTypeNotificationFactory.FetchPayrollRunTypeFail());
        }

        return builder.get();
    }
}
