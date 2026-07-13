package com.personal.management.payrollrunbenefit.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.country.entities.Country;
import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.management.payrollrunbenefit.notifications.PayrollRunBenefitNotificationFactory;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedPayrollRun;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunBenefitService extends FilterService<PayrollRunBenefit> {

    public FilterPayrollRunBenefitService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollRunBenefit> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_runs_benefits",
                "id", "country_id", "payroll_benefits_id", "payroll_runs_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(PayrollRunBenefit::new)
                    .With(PayrollRunBenefit::setId, dbRow.column("id").getString())
                    .With(PayrollRunBenefit::setCountry, new Country(dbRow.column("country_id").getString()))
                    .With(PayrollRunBenefit::setBenefit, new SharedBenefit(dbRow.column("payroll_benefits_id").getString()))
                    .With(PayrollRunBenefit::setPayrollRun, new SharedPayrollRun(dbRow.column("payroll_runs_id").getString()))
                    .With(PayrollRunBenefit::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollRunBenefit::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollRunBenefit::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollRunBenefitNotificationFactory.FetchPayrollRunBenefitSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollRunBenefitNotificationFactory.FetchPayrollRunBenefitFail());
        }

        return builder.get();
    }
}
