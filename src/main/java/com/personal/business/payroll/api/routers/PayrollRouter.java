package com.personal.business.payroll.api.routers;

import com.personal.business.payroll.create.routes.CreatePayrollHttpHandler;
import com.personal.business.payroll.delete.routes.DeletePayrollHttpHandler;
import com.personal.business.payroll.filter.routes.FilterPayrollHttpHandler;
import com.personal.business.payroll.update.routes.UpdatePayrollHttpHandler;

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
