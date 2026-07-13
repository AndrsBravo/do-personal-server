package com.personal.business.temporalfrequency.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.business.temporalfrequency.notifications.TemporalFrequencyNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterTemporalFrequencyService extends FilterService<TemporalFrequency> {

    public FilterTemporalFrequencyService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<TemporalFrequency> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("temporal_frequencies",
                "id", "tf_category", "tf_title", "tf_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(TemporalFrequency::new)
                    .With(TemporalFrequency::setId, dbRow.column("id").getString())
                    .With(TemporalFrequency::setFrequency, dbRow.column("tf_category").getString())
                    .With(TemporalFrequency::setTitle, dbRow.column("tf_title").getString())
                    .With(TemporalFrequency::setDescription, dbRow.column("tf_description").getString())
                    .With(TemporalFrequency::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(TemporalFrequency::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(TemporalFrequency::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(TemporalFrequencyNotificationFactory.FetchTemporalFrequencySuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(TemporalFrequencyNotificationFactory.FetchTemporalFrequencyFail());
        }

        return builder.get();
    }
}
