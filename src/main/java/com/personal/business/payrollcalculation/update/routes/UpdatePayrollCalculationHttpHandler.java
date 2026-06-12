package com.personal.business.payrollcalculation.update.routes;

import com.personal.business.payrollcalculation.create.inputs.PayrollCalculationInput;
import com.personal.business.payrollcalculation.update.process.UpdatePayrollCalculationProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollCalculationHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollCalculation = request.content().as(PayrollCalculationInput.class);

        var updatePayrollCalculation = UpdatePayrollCalculationProcessExecutor.builder()
                .init(payrollCalculation.getPayrollCalculation())
                .execute();

        switch (updatePayrollCalculation.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollCalculation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollCalculation.getInitObject());
        }
    }

}
