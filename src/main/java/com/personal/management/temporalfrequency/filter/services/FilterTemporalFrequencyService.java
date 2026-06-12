package com.personal.management.temporalfrequency.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.temporalfrequency.factories.TemporalFrequencyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterTemporalFrequencyService implements IFilterService<TemporalFrequency> {

    private final Optional<DbClient> dbClient;

    public FilterTemporalFrequencyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<TemporalFrequency>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return TemporalFrequencyResultFactory.FetchNull();
        }

        var queryString = query.Select("temporal_frequencies",
                "id", "tf_category", "tf_title", "tf_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new TemporalFrequency();
                    u.setId(dbRow.column("id").getString());
                    u.setFrequency(dbRow.column("tf_category").getString());
                    u.setTitle(dbRow.column("tf_title").getString());
                    u.setDescription(dbRow.column("tf_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return TemporalFrequencyResultFactory.FetchNull();
        }

        return TemporalFrequencyResultFactory.FetchResult(result);
    }
}
