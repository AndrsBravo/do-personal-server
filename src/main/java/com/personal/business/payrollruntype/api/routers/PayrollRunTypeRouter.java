package com.personal.business.payrollruntype.api.routers;

import com.personal.business.payrollruntype.create.routes.CreatePayrollRunTypeHttpHandler;
import com.personal.business.payrollruntype.delete.routes.DeletePayrollRunTypeHttpHandler;
import com.personal.business.payrollruntype.filter.routes.FilterPayrollRunTypeHttpHandler;
import com.personal.business.payrollruntype.update.routes.UpdatePayrollRunTypeHttpHandler;

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
