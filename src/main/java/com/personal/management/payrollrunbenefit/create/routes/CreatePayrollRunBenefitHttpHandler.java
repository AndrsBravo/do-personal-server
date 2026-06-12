package com.personal.management.payrollrunbenefit.create.routes;

import com.personal.management.payrollrunbenefit.create.inputs.PayrollRunBenefitInput;
import com.personal.management.payrollrunbenefit.create.process.CreatePayrollRunBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollRunBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunBenefit = request.content().as(PayrollRunBenefitInput.class);

        var createPayrollRunBenefit = CreatePayrollRunBenefitProcessExecutor.builder()
                .init(payrollRunBenefit.getPayrollRunBenefit())
                .execute();
        switch (createPayrollRunBenefit.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createPayrollRunBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createPayrollRunBenefit.getInitObject());
        }
    }
}
