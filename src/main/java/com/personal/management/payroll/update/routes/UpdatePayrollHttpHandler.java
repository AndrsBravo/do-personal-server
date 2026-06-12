package com.personal.management.payroll.update.routes;

import com.personal.management.payroll.create.inputs.PayrollInput;
import com.personal.management.payroll.update.process.UpdatePayrollProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payroll = request.content().as(PayrollInput.class);

        var updatePayroll = UpdatePayrollProcessExecutor.builder()
                .init(payroll.getPayroll())
                .execute();

        switch (updatePayroll.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayroll.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayroll.getInitObject());
        }
    }

}
