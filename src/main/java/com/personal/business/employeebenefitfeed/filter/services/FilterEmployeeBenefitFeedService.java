package com.personal.business.employeebenefitfeed.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.factories.EmployeeBenefitFeedResultFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeBenefitFeedService implements IFilterService<EmployeeBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public FilterEmployeeBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<EmployeeBenefitFeed>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeBenefitFeedResultFactory.FetchNull();
        }

        var queryString = query.Select("employee_benefits_feeds",
                "id", "business_id", "business_benefits_id", "employee_benefit_id", "temporal_frequency_id", "ebf_amount", "ebf_started_at", "ebf_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> EntityBuilder.Of(EmployeeBenefitFeed::new)
                .With(EmployeeBenefitFeed::setId, dbRow.column("id").getString())
                .With(EmployeeBenefitFeed::setBusiness, new Business(dbRow.column("business_id").getString()))
                .With(EmployeeBenefitFeed::setBenefit, new Benefit(dbRow.column("business_benefits_id").getString()))
                .With(EmployeeBenefitFeed::setEmployee, new Employee(dbRow.column("employee_benefit_id").getString()))
                .With(EmployeeBenefitFeed::setTemporalFrequency, new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()))
                .With(EmployeeBenefitFeed::setAmount, dbRow.column("ebf_amount").get(Double.class))
                .With(EmployeeBenefitFeed::setStartedAt, dbRow.column("ebf_started_at").get(LocalDateTime.class))
                .With(EmployeeBenefitFeed::setEndedAt, dbRow.column("ebf_ended_at").get(LocalDateTime.class))
                .With(EmployeeBenefitFeed::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                .With(EmployeeBenefitFeed::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                .With(EmployeeBenefitFeed::setCreatedBy, new User(dbRow.column("created_by").getString()))
                .Get()
                )
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return EmployeeBenefitFeedResultFactory.FetchNull();
        }

        return EmployeeBenefitFeedResultFactory.FetchResult(result);
    }
}
