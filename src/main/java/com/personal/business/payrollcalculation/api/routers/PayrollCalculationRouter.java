package com.personal.business.payrollcalculation.api.routers;

import com.personal.business.payrollcalculation.create.routes.CreatePayrollCalculationHttpHandler;
import com.personal.business.payrollcalculation.delete.routes.DeletePayrollCalculationHttpHandler;
import com.personal.business.payrollcalculation.filter.routes.FilterPayrollCalculationHttpHandler;
import com.personal.business.payrollcalculation.update.routes.UpdatePayrollCalculationHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollCalculationRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollCalculationHttpHandler()::Post);
        rules.put("/", new UpdatePayrollCalculationHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollCalculationHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollCalculationHttpHandler()::Post);
    }
}
