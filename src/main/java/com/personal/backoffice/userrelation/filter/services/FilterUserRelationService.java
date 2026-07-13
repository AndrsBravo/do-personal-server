package com.personal.backoffice.userrelation.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrelation.notifications.UserRelationNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterUserRelationService extends FilterService<UserRelation> {

    public FilterUserRelationService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<UserRelation> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("user_relation",
                "id", "ur_relation", "ur_title", "ur_description", "ur_updated_at", "ur_created_at", "ur_created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow)
                            -> EntityBuilder.Of(UserRelation::new)
                            .With(UserRelation::setId, dbRow.column("id").getString())
                            .With(UserRelation::setRelation, dbRow.column("ur_relation").getString())
                            .With(UserRelation::setTitle, dbRow.column("ur_title").getString())
                            .With(UserRelation::setDescription, dbRow.column("ur_description").getString())
                            .With(UserRelation::setCreatedAt, dbRow.column("ur_created_at").get(LocalDateTime.class))
                            .With(UserRelation::setUpdatedAt, dbRow.column("ur_updated_at").get(LocalDateTime.class))
                            .With(UserRelation::setCreatedBy, new User(dbRow.column("ur_created_by").getString()))
                            .Get()
                    )
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(UserRelationNotificationFactory.FetchUserRelationSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(UserRelationNotificationFactory.FetchUserRelationFail());
        }

        return builder.get();
    }
}
