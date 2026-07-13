package com.personal.business.deductionrate.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.deductionrate.entities.DeductionRate;
import com.personal.business.deductionrate.notifications.DeductionRateNotificationFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterDeductionRateService extends FilterService<DeductionRate> {

    public FilterDeductionRateService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<DeductionRate> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("business_deductions_rates",
                "id", "business_id", "business_deduction_id", "temporal_frequency_id", "bdr_amount", "bdr_base_amount", "bdr_rate", "bdr_level", "bdr_started_at", "bdr_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(DeductionRate::new)
                    .With(DeductionRate::setId, dbRow.column("id").getString())
                    .With(DeductionRate::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(DeductionRate::setDeduction, new Deduction(dbRow.column("business_deduction_id").getString()))
                    .With(DeductionRate::setRate, dbRow.column("business_deduction_id").getDouble())
                    .With(DeductionRate::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                    .With(DeductionRate::setAmount, dbRow.column("bdr_amount").getDouble())
                    .With(DeductionRate::setBaseAmount, dbRow.column("bdr_base_amount").getDouble())
                    .With(DeductionRate::setRate, dbRow.column("bdr_rate").getDouble())
                    .With(DeductionRate::setLevel, dbRow.column("bdr_level").get(Byte.class))
                    .With(DeductionRate::setStartedAt, dbRow.column("bdr_started_at").get(LocalDateTime.class))
                    .With(DeductionRate::setEndedAt, dbRow.column("bdr_ended_at").get(LocalDateTime.class))
                    .With(DeductionRate::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(DeductionRate::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(DeductionRate::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(DeductionRateNotificationFactory.FetchDeductionRateSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(DeductionRateNotificationFactory.FetchDeductionRateFail());
        }

        return builder.get();
    }
}
