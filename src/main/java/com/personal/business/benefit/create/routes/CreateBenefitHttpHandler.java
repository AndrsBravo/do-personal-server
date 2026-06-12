package com.personal.business.benefit.create.routes;

import com.personal.business.benefit.create.inputs.BenefitInput;
import com.personal.business.benefit.create.process.CreateBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefit = request.content().as(BenefitInput.class);

        var createBenefit = CreateBenefitProcessExecutor.builder()
                .init(benefit.getBenefit())
                .execute();
        switch (createBenefit.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createBenefit.getInitObject());
        }
    }
}
