package com.personal.management.payrollrunbenefit.api.routers;

import com.personal.management.payrollrunbenefit.create.routes.CreatePayrollRunBenefitHttpHandler;
import com.personal.management.payrollrunbenefit.delete.routes.DeletePayrollRunBenefitHttpHandler;
import com.personal.management.payrollrunbenefit.filter.routes.FilterPayrollRunBenefitHttpHandler;
import com.personal.management.payrollrunbenefit.update.routes.UpdatePayrollRunBenefitHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollRunBenefitRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollRunBenefitHttpHandler()::Post);
        rules.put("/", new UpdatePayrollRunBenefitHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollRunBenefitHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollRunBenefitHttpHandler()::Post);
    }
}
