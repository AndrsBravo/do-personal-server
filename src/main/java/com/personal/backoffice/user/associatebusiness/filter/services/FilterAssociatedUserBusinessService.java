package com.personal.backoffice.user.associatebusiness.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.associatebusiness.entities.AssociateUserBusiness;
import com.personal.backoffice.user.entities.User;
import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.backoffice.userrelation.entities.UserRelation;
import com.personal.backoffice.userrole.entities.UserRole;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterAssociatedUserBusinessService extends FilterService<AssociateUserBusiness> {

    public FilterAssociatedUserBusinessService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<AssociateUserBusiness> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("user_has_business",
                "id", "business_id", "users_id", "user_role_id", "user_relation_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(AssociateUserBusiness::new)
                    .With(AssociateUserBusiness::setId, dbRow.column("id").getString())
                    .With(AssociateUserBusiness::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(AssociateUserBusiness::setUser, new User(dbRow.column("users_id").getString()))
                    .With(AssociateUserBusiness::setUserRole, new UserRole(dbRow.column("user_role_id").getString()))
                    .With(AssociateUserBusiness::setUserRelation, new UserRelation(dbRow.column("user_relation_id").getString()))
                    .With(AssociateUserBusiness::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(AssociateUserBusiness::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(AssociateUserBusiness::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get()).collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(UserNotificationFactory.FetchAssociatedUserBusinessSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(UserNotificationFactory.FetchAssociatedUserBusinessFail());
        }
        return builder.get();
    }
}
