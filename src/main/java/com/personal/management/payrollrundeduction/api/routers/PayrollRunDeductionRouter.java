package com.personal.management.payrollrundeduction.api.routers;

import com.personal.management.payrollrundeduction.create.routes.CreatePayrollRunDeductionHttpHandler;
import com.personal.management.payrollrundeduction.delete.routes.DeletePayrollRunDeductionHttpHandler;
import com.personal.management.payrollrundeduction.filter.routes.FilterPayrollRunDeductionHttpHandler;
import com.personal.management.payrollrundeduction.update.routes.UpdatePayrollRunDeductionHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollRunDeductionRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollRunDeductionHttpHandler()::Post);
        rules.put("/", new UpdatePayrollRunDeductionHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollRunDeductionHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollRunDeductionHttpHandler()::Post);
    }
}
