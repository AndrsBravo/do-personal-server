package com.personal.business.payrolldeduction.create.routes;

import com.personal.business.payrolldeduction.create.inputs.PayrollDeductionInput;
import com.personal.business.payrolldeduction.create.process.CreatePayrollDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollDeduction = request.content().as(PayrollDeductionInput.class);

        var createPayrollDeduction = CreatePayrollDeductionProcessExecutor.builder()
                .init(payrollDeduction.getPayrollDeduction())
                .execute();
        switch (createPayrollDeduction.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollDeduction.getInitObject());
        }
    }
}
