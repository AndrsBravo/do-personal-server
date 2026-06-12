package com.personal.business.payrollrunbenefit.api.routers;

import com.personal.business.payrollrunbenefit.create.routes.CreatePayrollRunBenefitHttpHandler;
import com.personal.business.payrollrunbenefit.delete.routes.DeletePayrollRunBenefitHttpHandler;
import com.personal.business.payrollrunbenefit.filter.routes.FilterPayrollRunBenefitHttpHandler;
import com.personal.business.payrollrunbenefit.update.routes.UpdatePayrollRunBenefitHttpHandler;

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
