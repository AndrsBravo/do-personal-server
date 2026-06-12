package com.personal.business.employeedeductionfeed.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.factories.EmployeeDeductionFeedResultFactory;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterEmployeeDeductionFeedService implements IFilterService<EmployeeDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public FilterEmployeeDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<EmployeeDeductionFeed>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return EmployeeDeductionFeedResultFactory.FetchNull();
        }

        var queryString = query.Select("employee_deductions_feeds",
                "id", "business_id", "business_deductions_id", "employee_deduction_id", "temporal_frequency_id", "ebf_amount", "ebf_started_at", "ebf_ended_at", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var employeeDeductionFeed = new EmployeeDeductionFeed();
                    employeeDeductionFeed.setId(dbRow.column("id").getString());
                    employeeDeductionFeed.setBusiness(new Business(dbRow.column("business_id").getString()));
                    employeeDeductionFeed.setDeduction(new Deduction(dbRow.column("business_deductions_id").getString()));
                    employeeDeductionFeed.setEmployee(new Employee(dbRow.column("employee_deduction_id").getString()));
                    employeeDeductionFeed.setTemporalFrequency(new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()));
                    employeeDeductionFeed.setAmount(dbRow.column("ebf_amount").get(Double.class));
                    employeeDeductionFeed.setStartedAt(dbRow.column("ebf_started_at").get(LocalDateTime.class));
                    employeeDeductionFeed.setEndedAt(dbRow.column("ebf_ended_at").get(LocalDateTime.class));
                    employeeDeductionFeed.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    employeeDeductionFeed.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    employeeDeductionFeed.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return employeeDeductionFeed;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return EmployeeDeductionFeedResultFactory.FetchNull();
        }

        return EmployeeDeductionFeedResultFactory.FetchResult(result);
    }
}
