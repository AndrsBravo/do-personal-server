package com.personal.business.payrollemployee.api.routers;

import com.personal.business.payrollemployee.create.routes.CreatePayrollEmployeeHttpHandler;
import com.personal.business.payrollemployee.delete.routes.DeletePayrollEmployeeHttpHandler;
import com.personal.business.payrollemployee.filter.routes.FilterPayrollEmployeeHttpHandler;
import com.personal.business.payrollemployee.update.routes.UpdatePayrollEmployeeHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollEmployeeRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollEmployeeHttpHandler()::Post);
        rules.put("/", new UpdatePayrollEmployeeHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollEmployeeHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollEmployeeHttpHandler()::Post);
    }
}
