package com.personal.business.payrollrundeduction.create.routes;

import com.personal.business.payrollrundeduction.create.inputs.PayrollRunDeductionInput;
import com.personal.business.payrollrundeduction.create.process.CreatePayrollRunDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollRunDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunDeduction = request.content().as(PayrollRunDeductionInput.class);

        var createPayrollRunDeduction = CreatePayrollRunDeductionProcessExecutor.builder()
                .init(payrollRunDeduction.getPayrollRunRunDeduction())
                .execute();
        switch (createPayrollRunDeduction.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollRunDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollRunDeduction.getInitObject());
        }
    }
}
