package com.personal.business.payrollrunresult.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollrunresult.entities.PayrollRunResult;
import com.personal.business.payrollrunresult.notifications.PayrollRunResultNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunResultService extends FilterService<PayrollRunResult> {

    public FilterPayrollRunResultService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollRunResult> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_runs_results",
                "id", "payrolls_id", "business_id", "prcr_title", "ref_id", "ref_title", "prcr_quantity", "prcr_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(PayrollRunResult::new)
                    .With(PayrollRunResult::setId, dbRow.column("id").getString())
                    .With(PayrollRunResult::setPayroll, new Payroll(dbRow.column("payrolls_id").getString()))
                    .With(PayrollRunResult::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(PayrollRunResult::setTitle, dbRow.column("prcr_title").getString())
                    .With(PayrollRunResult::setReference, dbRow.column("ref_id").getString())
                    .With(PayrollRunResult::setReferenceTitle, dbRow.column("ref_title").getString())
                    .With(PayrollRunResult::setQuantity, dbRow.column("prcr_quantity").get(Double.class))
                    .With(PayrollRunResult::setDescription, dbRow.column("prcr_description").getString())
                    .With(PayrollRunResult::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollRunResult::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollRunResult::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollRunResultNotificationFactory.FetchPayrollRunResultSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollRunResultNotificationFactory.FetchPayrollRunResultFail());
        }

        return builder.get();
    }
}
