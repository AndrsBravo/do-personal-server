package com.personal.business.payrollcalculationresult.update.routes;

import com.personal.business.payrollcalculationresult.create.inputs.PayrollCalculationResultInput;
import com.personal.business.payrollcalculationresult.update.process.UpdatePayrollCalculationResultProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollCalculationResultHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollCalculationResult = request.content().as(PayrollCalculationResultInput.class);

        var updatePayrollCalculationResult = UpdatePayrollCalculationResultProcessExecutor.builder()
                .init(payrollCalculationResult.getPayrollCalculationResult())
                .execute();

        switch (updatePayrollCalculationResult.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollCalculationResult.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollCalculationResult.getInitObject());
        }
    }

}
