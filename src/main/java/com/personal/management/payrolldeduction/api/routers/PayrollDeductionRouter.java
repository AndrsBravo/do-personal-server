package com.personal.management.payrolldeduction.api.routers;

import com.personal.management.payrolldeduction.create.routes.CreatePayrollDeductionHttpHandler;
import com.personal.management.payrolldeduction.delete.routes.DeletePayrollDeductionHttpHandler;
import com.personal.management.payrolldeduction.filter.routes.FilterPayrollDeductionHttpHandler;
import com.personal.management.payrolldeduction.update.routes.UpdatePayrollDeductionHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollDeductionRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollDeductionHttpHandler()::Post);
        rules.put("/", new UpdatePayrollDeductionHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollDeductionHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollDeductionHttpHandler()::Post);
    }
}
