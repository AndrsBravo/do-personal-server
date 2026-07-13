package com.personal.business.employeedeductionfeed.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.notifications.EmployeeDeductionFeedNotificationFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeDeductionFeedService extends FilterService<EmployeeDeductionFeed> {

    public FilterEmployeeDeductionFeedService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<EmployeeDeductionFeed> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("employee_deductions_feeds",
                "id", "business_id", "business_deductions_id", "employee_deduction_id", "temporal_frequency_id", "ebf_amount", "ebf_started_at", "ebf_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(EmployeeDeductionFeed::new)
                    .With(EmployeeDeductionFeed::setId, dbRow.column("id").getString())
                    .With(EmployeeDeductionFeed::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(EmployeeDeductionFeed::setDeduction, new Deduction(dbRow.column("business_deductions_id").getString()))
                    .With(EmployeeDeductionFeed::setEmployee, new Employee(dbRow.column("employee_deduction_id").getString()))
                    .With(EmployeeDeductionFeed::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                    .With(EmployeeDeductionFeed::setAmount, dbRow.column("ebf_amount").get(Double.class))
                    .With(EmployeeDeductionFeed::setStartedAt, dbRow.column("ebf_started_at").get(LocalDateTime.class))
                    .With(EmployeeDeductionFeed::setEndedAt, dbRow.column("ebf_ended_at").get(LocalDateTime.class))
                    .With(EmployeeDeductionFeed::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(EmployeeDeductionFeed::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(EmployeeDeductionFeed::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(EmployeeDeductionFeedNotificationFactory.FetchEmployeeDeductionFeedSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(EmployeeDeductionFeedNotificationFactory.FetchEmployeeDeductionFeedFail());
        }

        return builder.get();
    }
}
