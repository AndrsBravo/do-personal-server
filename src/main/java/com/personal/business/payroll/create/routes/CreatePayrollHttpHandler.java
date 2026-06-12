package com.personal.business.payroll.create.routes;

import com.personal.business.payroll.create.inputs.PayrollInput;
import com.personal.business.payroll.create.process.CreatePayrollProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payroll = request.content().as(PayrollInput.class);

        var createPayroll = CreatePayrollProcessExecutor.builder()
                .init(payroll.getPayroll())
                .execute();
        switch (createPayroll.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayroll.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayroll.getInitObject());
        }
    }
}
