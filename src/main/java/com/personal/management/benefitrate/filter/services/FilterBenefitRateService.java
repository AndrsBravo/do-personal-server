package com.personal.management.benefitrate.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.factories.BenefitRateResultFactory;
import com.personal.management.country.entities.Country;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedTemporalFrequency;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitRateService implements IFilterService<BenefitRate> {

    private final Optional<DbClient> dbClient;

    public FilterBenefitRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<BenefitRate>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitRateResultFactory.FetchNull();
        }

        var queryString = query.Select("business_benefits_rates",
                "id", "country_id", "business_benefit_id", "temporal_frequency_id", "bbr_amount", "bbr_base_amount", "bbr_rate", "bbr_level", "bbr_started_at", "bbr_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var benefitRate = new BenefitRate();
                    benefitRate.setId(dbRow.column("id").getString());
                    benefitRate.setCountry(new Country(dbRow.column("country_id").getString()));
                    benefitRate.setBenefit(new Benefit(dbRow.column("business_benefit_id").getString()));
                    benefitRate.setRate(dbRow.column("business_benefit_id").getDouble());
                    benefitRate.setTemporalFrequency(new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()));
                    benefitRate.setAmount(dbRow.column("bbr_amount").getDouble());
                    benefitRate.setBaseAmount(dbRow.column("bbr_base_amount").getDouble());
                    benefitRate.setRate(dbRow.column("bbr_rate").getDouble());
                    benefitRate.setLevel(dbRow.column("bbr_level").get(Byte.class));
                    benefitRate.setStartedAt(dbRow.column("bbr_started_at").get(LocalDateTime.class));
                    benefitRate.setEndedAt(dbRow.column("bbr_ended_at").get(LocalDateTime.class));
                    benefitRate.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    benefitRate.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    benefitRate.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return benefitRate;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return BenefitRateResultFactory.FetchNull();
        }

        return BenefitRateResultFactory.FetchResult(result);
    }
}
