package com.personal.management.payrolldeduction.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.country.entities.Country;
import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.notifications.PayrollDeductionNotificationFactory;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayroll;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollDeductionService extends FilterService<PayrollDeduction> {

    public FilterPayrollDeductionService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollDeduction> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_deductions",
                "id", "country_id", "business_deductions_id", "payrolls_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(PayrollDeduction::new)
                    .With(PayrollDeduction::setId, dbRow.column("id").getString())
                    .With(PayrollDeduction::setCountry, new Country(dbRow.column("country_id").getString()))
                    .With(PayrollDeduction::setDeduction, new SharedDeduction(dbRow.column("business_deductions_id").getString()))
                    .With(PayrollDeduction::setPayroll, new SharedPayroll(dbRow.column("payrolls_id").getString()))
                    .With(PayrollDeduction::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollDeduction::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollDeduction::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollDeductionNotificationFactory.FetchPayrollDeductionSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollDeductionNotificationFactory.FetchPayrollDeductionFail());
        }

        return builder.get();
    }
}
