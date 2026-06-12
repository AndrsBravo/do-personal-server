package com.personal.business.payrollrun.api.routers;

import com.personal.business.payrollrun.create.routes.CreatePayrollRunHttpHandler;
import com.personal.business.payrollrun.delete.routes.DeletePayrollRunHttpHandler;
import com.personal.business.payrollrun.filter.routes.FilterPayrollRunHttpHandler;
import com.personal.business.payrollrun.update.routes.UpdatePayrollRunHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollRunRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollRunHttpHandler()::Post);
        rules.put("/", new UpdatePayrollRunHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollRunHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollRunHttpHandler()::Post);
    }
}
