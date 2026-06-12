package com.personal.management.payroll.api.routers;

import com.personal.management.payroll.create.routes.CreatePayrollHttpHandler;
import com.personal.management.payroll.delete.routes.DeletePayrollHttpHandler;
import com.personal.management.payroll.filter.routes.FilterPayrollHttpHandler;
import com.personal.management.payroll.update.routes.UpdatePayrollHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollHttpHandler()::Post);
        rules.put("/", new UpdatePayrollHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollHttpHandler()::Post);
    }
}
