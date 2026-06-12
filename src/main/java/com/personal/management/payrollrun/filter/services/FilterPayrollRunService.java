package com.personal.management.payrollrun.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.payroll.entities.Payroll;
import com.personal.management.payrollrun.entities.PayrollRun;
import com.personal.management.payrollrun.factories.PayrollRunResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollRunService implements IFilterService<PayrollRun> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollRunService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollRun>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollRunResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_runs",
                "id", "payrolls_id", "prr_title", "prr_description", "payroll_runs_type_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var payrollRun = new PayrollRun();
                    payrollRun.setId(dbRow.column("id").getString());
                    payrollRun.setPayroll(new Payroll(dbRow.column("payrolls_id").getString()));
                    payrollRun.setTitle(dbRow.column("prr_title").getString());
                    payrollRun.setDescription(dbRow.column("prr_description").getString());
                    payrollRun.setPayrollRunType(new TypeEntityBase(dbRow.column("payroll_runs_type_id").getString()));
                    payrollRun.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    payrollRun.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    payrollRun.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return payrollRun;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollRunResultFactory.FetchNull();
        }

        return PayrollRunResultFactory.FetchResult(result);
    }
}
