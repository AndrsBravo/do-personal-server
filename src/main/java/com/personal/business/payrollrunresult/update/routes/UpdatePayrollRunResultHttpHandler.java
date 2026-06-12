package com.personal.business.payrollrunresult.update.routes;

import com.personal.business.payrollrunresult.create.inputs.PayrollRunResultInput;
import com.personal.business.payrollrunresult.update.process.UpdatePayrollRunResultProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollRunResultHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollRunResult = request.content().as(PayrollRunResultInput.class);

        var updatePayrollRunResult = UpdatePayrollRunResultProcessExecutor.builder()
                .init(payrollRunResult.getPayrollRunResult())
                .execute();

        switch (updatePayrollRunResult.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollRunResult.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollRunResult.getInitObject());
        }
    }

}
