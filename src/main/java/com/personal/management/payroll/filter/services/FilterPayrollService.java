package com.personal.management.payroll.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payroll.factories.PayrollResultFactory;
import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollService implements IFilterService<Payroll> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Payroll>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollResultFactory.FetchNull();
        }

        var queryString = query.Select("payrolls",
                "id", "pr_payroll", "pr_title", "pr_description", "temporal_frequency_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var payroll = new Payroll();
                    payroll.setId(dbRow.column("id").getString());
                    payroll.setPayroll(dbRow.column("pr_payroll").getString());
                    payroll.setTitle(dbRow.column("pr_title").getString());
                    payroll.setDescription(dbRow.column("pr_description").getString());
                    payroll.setTemporalFrequency(new TemporalFrequency(dbRow.column("temporal_frequency_id").getString()));
                    payroll.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    payroll.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    payroll.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return payroll;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollResultFactory.FetchNull();
        }

        return PayrollResultFactory.FetchResult(result);
    }
}
