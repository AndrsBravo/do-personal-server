package com.personal.business.payrollrunresult.api.routers;

import com.personal.business.payrollrunresult.create.routes.CreatePayrollRunResultHttpHandler;
import com.personal.business.payrollrunresult.delete.routes.DeletePayrollRunResultHttpHandler;
import com.personal.business.payrollrunresult.filter.routes.FilterPayrollRunResultHttpHandler;
import com.personal.business.payrollrunresult.update.routes.UpdatePayrollRunResultHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollRunResultRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollRunResultHttpHandler()::Post);
        rules.put("/", new UpdatePayrollRunResultHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollRunResultHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollRunResultHttpHandler()::Post);
    }
}
