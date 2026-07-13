package com.personal.business.payrollcalculationresult.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.business.entities.Business;
import com.personal.backoffice.user.entities.User;
import com.personal.business.payroll.entities.Payroll;
import com.personal.business.payrollcalculationresult.entities.PayrollCalculationResult;
import com.personal.business.payrollcalculationresult.notifications.PayrollCalculationResultNotificationFactory;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollCalculationResultService extends FilterService<PayrollCalculationResult> {

    public FilterPayrollCalculationResultService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<PayrollCalculationResult> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("payroll_calculations_results",
                "id", "payrolls_id", "business_id", "prcr_title", "ref_id", "ref_title", "prcr_quantity", "prcr_description", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(PayrollCalculationResult::new)
                    .With(PayrollCalculationResult::setId, dbRow.column("id").getString())
                    .With(PayrollCalculationResult::setPayroll, new Payroll(dbRow.column("payrolls_id").getString()))
                    .With(PayrollCalculationResult::setBusiness, new Business(dbRow.column("business_id").getString()))
                    .With(PayrollCalculationResult::setTitle, dbRow.column("prcr_title").getString())
                    .With(PayrollCalculationResult::setReference, dbRow.column("ref_id").getString())
                    .With(PayrollCalculationResult::setReferenceTitle, dbRow.column("ref_title").getString())
                    .With(PayrollCalculationResult::setQuantity, dbRow.column("prcr_quantity").get(Double.class))
                    .With(PayrollCalculationResult::setDescription, dbRow.column("prcr_description").getString())
                    .With(PayrollCalculationResult::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(PayrollCalculationResult::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(PayrollCalculationResult::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get())
                    .collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(PayrollCalculationResultNotificationFactory.FetchPayrollCalculationResultSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(PayrollCalculationResultNotificationFactory.FetchPayrollCalculationResultFail());
        }

        return builder.get();
    }
}
