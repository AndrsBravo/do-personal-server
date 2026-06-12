package com.personal.management.payrollbenefit.create.routes;

import com.personal.management.payrollbenefit.create.inputs.PayrollBenefitInput;
import com.personal.management.payrollbenefit.create.process.CreatePayrollBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollBenefit = request.content().as(PayrollBenefitInput.class);

        var createPayrollBenefit = CreatePayrollBenefitProcessExecutor.builder()
                .init(payrollBenefit.getPayrollBenefit())
                .execute();
        switch (createPayrollBenefit.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollBenefit.getInitObject());
        }
    }
}
