package com.personal.business.payrollbenefit.api.routers;

import com.personal.business.payrollbenefit.create.routes.CreatePayrollBenefitHttpHandler;
import com.personal.business.payrollbenefit.delete.routes.DeletePayrollBenefitHttpHandler;
import com.personal.business.payrollbenefit.filter.routes.FilterPayrollBenefitHttpHandler;
import com.personal.business.payrollbenefit.update.routes.UpdatePayrollBenefitHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollBenefitRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollBenefitHttpHandler()::Post);
        rules.put("/", new UpdatePayrollBenefitHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollBenefitHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollBenefitHttpHandler()::Post);
    }
}
