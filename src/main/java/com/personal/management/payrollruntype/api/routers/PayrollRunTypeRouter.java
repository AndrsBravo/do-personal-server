package com.personal.management.payrollruntype.api.routers;

import com.personal.management.payrollruntype.create.routes.CreatePayrollRunTypeHttpHandler;
import com.personal.management.payrollruntype.delete.routes.DeletePayrollRunTypeHttpHandler;
import com.personal.management.payrollruntype.filter.routes.FilterPayrollRunTypeHttpHandler;
import com.personal.management.payrollruntype.update.routes.UpdatePayrollRunTypeHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollRunTypeRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollRunTypeHttpHandler()::Post);
        rules.put("/", new UpdatePayrollRunTypeHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollRunTypeHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollRunTypeHttpHandler()::Post);
    }
}
