package com.personal.business.payrollcalculationresult.api.routers;

import com.personal.business.payrollcalculationresult.create.routes.CreatePayrollCalculationResultHttpHandler;
import com.personal.business.payrollcalculationresult.delete.routes.DeletePayrollCalculationResultHttpHandler;
import com.personal.business.payrollcalculationresult.filter.routes.FilterPayrollCalculationResultHttpHandler;
import com.personal.business.payrollcalculationresult.update.routes.UpdatePayrollCalculationResultHttpHandler;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class PayrollCalculationResultRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules.post("/", new CreatePayrollCalculationResultHttpHandler()::Post);
        rules.put("/", new UpdatePayrollCalculationResultHttpHandler()::Put);
        rules.delete("/{id}", new DeletePayrollCalculationResultHttpHandler()::Delete);
        rules.post("/filter", new FilterPayrollCalculationResultHttpHandler()::Post);
    }
}
