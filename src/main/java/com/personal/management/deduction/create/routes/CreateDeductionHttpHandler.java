package com.personal.management.deduction.create.routes;

import com.personal.management.deduction.create.inputs.DeductionInput;
import com.personal.management.deduction.create.process.CreateDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var deduction = request.content().as(DeductionInput.class);

        var createDeduction = CreateDeductionProcessExecutor.builder()
                .init(deduction.getDeduction())
                .execute();
        switch (createDeduction.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createDeduction.getInitObject());
        }
    }
}
