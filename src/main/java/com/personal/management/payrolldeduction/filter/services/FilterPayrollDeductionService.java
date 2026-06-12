package com.personal.management.payrolldeduction.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.country.entities.Country;
import com.personal.management.payrolldeduction.entities.PayrollDeduction;
import com.personal.management.payrolldeduction.factories.PayrollDeductionResultFactory;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.core.entities.SharedPayroll;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterPayrollDeductionService implements IFilterService<PayrollDeduction> {

    private final Optional<DbClient> dbClient;

    public FilterPayrollDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<PayrollDeduction>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return PayrollDeductionResultFactory.FetchNull();
        }

        var queryString = query.Select("payroll_deductions",
                "id", "country_id", "business_deductions_id", "payrolls_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var payrollDeduction = new PayrollDeduction();
                    payrollDeduction.setId(dbRow.column("id").getString());
                    payrollDeduction.setCountry(new Country(dbRow.column("country_id").getString()));
                    payrollDeduction.setDeduction(new SharedDeduction(dbRow.column("business_deductions_id").getString()));
                    payrollDeduction.setPayroll(new SharedPayroll(dbRow.column("payrolls_id").getString()));
                    payrollDeduction.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    payrollDeduction.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    payrollDeduction.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return payrollDeduction;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return PayrollDeductionResultFactory.FetchNull();
        }

        return PayrollDeductionResultFactory.FetchResult(result);
    }
}
