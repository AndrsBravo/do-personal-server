package com.personal.business.payrollrun.update.routes;

import com.personal.business.payrollrun.create.inputs.PayrollRunInput;
import com.personal.business.payrollrun.update.process.UpdatePayrollRunProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollRunHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollRun = request.content().as(PayrollRunInput.class);

        var updatePayrollRun = UpdatePayrollRunProcessExecutor.builder()
                .init(payrollRun.getPayrollRun())
                .execute();

        switch (updatePayrollRun.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollRun.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollRun.getInitObject());
        }
    }

}
