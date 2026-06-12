package com.personal.management.deductionrate.create.routes;

import com.personal.management.deductionrate.create.inputs.DeductionRateInput;
import com.personal.management.deductionrate.create.process.CreateDeductionRateProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateDeductionRateHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var deductionRate = request.content().as(DeductionRateInput.class);

        var createDeductionRate = CreateDeductionRateProcessExecutor.builder()
                .init(deductionRate.getDeductionRate())
                .execute();
        switch (createDeductionRate.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createDeductionRate.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createDeductionRate.getInitObject());
        }
    }
}
