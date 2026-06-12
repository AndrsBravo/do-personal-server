package com.personal.management.benefit.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.benefit.entities.Benefit;
import com.personal.management.benefit.factories.BenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitService implements IFilterService<Benefit> {

    private final Optional<DbClient> dbClient;

    public FilterBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Benefit>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitResultFactory.FetchNull();
        }

        var queryString = query.Select("business_benefits",
                "id", "bb_benefit", "bb_title", "bb_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new Benefit();
                    u.setId(dbRow.column("id").getString());
                    u.setBenefit(dbRow.column("bb_benefit").getString());
                    u.setTitle(dbRow.column("bb_title").getString());
                    u.setDescription(dbRow.column("bb_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return BenefitResultFactory.FetchNull();
        }

        return BenefitResultFactory.FetchResult(result);
    }
}
