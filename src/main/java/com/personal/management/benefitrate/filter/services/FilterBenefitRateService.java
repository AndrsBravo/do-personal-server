package com.personal.management.benefitrate.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.benefitrate.entities.BenefitRate;
import com.personal.management.benefitrate.notifications.BenefitRateNotificationFactory;
import com.personal.management.country.entities.Country;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitRateService extends FilterService<BenefitRate> {

    public FilterBenefitRateService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<BenefitRate> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("business_benefits_rates",
                "id", "country_id", "business_benefit_id", "temporal_frequency_id", "bbr_amount", "bbr_base_amount", "bbr_rate", "bbr_level", "bbr_started_at", "bbr_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(BenefitRate::new)
                    .With(BenefitRate::setId, dbRow.column("id").getString())
                    .With(BenefitRate::setCountry, new Country(dbRow.column("country_id").getString()))
                    .With(BenefitRate::setBenefit, new Benefit(dbRow.column("business_benefit_id").getString()))
                    .With(BenefitRate::setRate, dbRow.column("business_benefit_id").getDouble())
                    .With(BenefitRate::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                    .With(BenefitRate::setAmount, dbRow.column("bbr_amount").getDouble())
                    .With(BenefitRate::setBaseAmount, dbRow.column("bbr_base_amount").getDouble())
                    .With(BenefitRate::setRate, dbRow.column("bbr_rate").getDouble())
                    .With(BenefitRate::setLevel, dbRow.column("bbr_level").get(Byte.class))
                    .With(BenefitRate::setStartedAt, dbRow.column("bbr_started_at").get(LocalDateTime.class))
                    .With(BenefitRate::setEndedAt, dbRow.column("bbr_ended_at").get(LocalDateTime.class))
                    .With(BenefitRate::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(BenefitRate::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(BenefitRate::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(BenefitRateNotificationFactory.FetchBenefitRateSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(BenefitRateNotificationFactory.FetchBenefitRateFail());
        }

        return builder.get();
    }
}
