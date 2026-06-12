package com.personal.business.payrollemployee.create.routes;

import com.personal.business.payrollemployee.create.inputs.PayrollEmployeeInput;
import com.personal.business.payrollemployee.create.process.CreatePayrollEmployeeProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollEmployeeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollEmployee = request.content().as(PayrollEmployeeInput.class);

        var createPayrollEmployee = CreatePayrollEmployeeProcessExecutor.builder()
                .init(payrollEmployee.getPayrollEmployee())
                .execute();
        switch (createPayrollEmployee.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollEmployee.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollEmployee.getInitObject());
        }
    }
}
