package com.personal.management.deductionrate.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.country.entities.Country;
import com.personal.management.deductionrate.entities.DeductionRate;
import com.personal.management.deductionrate.factories.DeductionRateResultFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterDeductionRateService implements IFilterService<DeductionRate> {

    private final Optional<DbClient> dbClient;

    public FilterDeductionRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<DeductionRate>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return DeductionRateResultFactory.FetchNull();
        }

        var queryString = query.Select("business_deductions_rates",
                "id", "country_id", "business_deduction_id", "temporal_frequency_id", "bdr_amount", "bdr_base_amount", "bdr_rate", "bdr_level", "bdr_started_at", "bdr_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(DeductionRate::new)
                .With(DeductionRate::setId, dbRow.column("id").getString())
                .With(DeductionRate::setCountry, new Country(dbRow.column("country_id").getString()))
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

        if (result.isEmpty()) {
            return DeductionRateResultFactory.FetchNull();
        }

        return DeductionRateResultFactory.FetchResult(result);
    }
}
