package com.personal.business.payrollrundeduction.api.routers;

import com.personal.business.payrollrundeduction.create.routes.CreatePayrollRunDeductionHttpHandler;
import com.personal.business.payrollrundeduction.delete.routes.DeletePayrollRunDeductionHttpHandler;
import com.personal.business.payrollrundeduction.filter.routes.FilterPayrollRunDeductionHttpHandler;
import com.personal.business.payrollrundeduction.update.routes.UpdatePayrollRunDeductionHttpHandler;

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
