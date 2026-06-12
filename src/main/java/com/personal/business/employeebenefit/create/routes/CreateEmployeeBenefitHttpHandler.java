package com.personal.business.employeebenefit.create.routes;

import com.personal.business.employeebenefit.create.inputs.EmployeeBenefitInput;
import com.personal.business.employeebenefit.create.process.CreateEmployeeBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateEmployeeBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var employeeBenefit = request.content().as(EmployeeBenefitInput.class);

        var createEmployeeBenefit = CreateEmployeeBenefitProcessExecutor.builder()
                .init(employeeBenefit.getEmployeeBenefit())
                .execute();
        switch (createEmployeeBenefit.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createEmployeeBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createEmployeeBenefit.getInitObject());
        }
    }
}
