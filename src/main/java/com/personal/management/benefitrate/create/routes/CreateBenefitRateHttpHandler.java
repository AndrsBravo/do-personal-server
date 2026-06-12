package com.personal.management.benefitrate.create.routes;

import com.personal.management.benefitrate.create.inputs.BenefitRateInput;
import com.personal.management.benefitrate.create.process.CreateBenefitRateProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateBenefitRateHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefitRate = request.content().as(BenefitRateInput.class);

        var createBenefitRate = CreateBenefitRateProcessExecutor.builder()
                .init(benefitRate.getBenefitRate())
                .execute();
        switch (createBenefitRate.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createBenefitRate.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createBenefitRate.getInitObject());
        }
    }
}
