package com.personal.management.benefitrate.update.routes;

import com.personal.management.benefitrate.create.inputs.BenefitRateInput;
import com.personal.management.benefitrate.update.process.UpdateBenefitRateProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateBenefitRateHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var benefitRate = request.content().as(BenefitRateInput.class);

        var updateBenefitRate = UpdateBenefitRateProcessExecutor.builder()
                .init(benefitRate.getBenefitRate())
                .execute();

        switch (updateBenefitRate.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateBenefitRate.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateBenefitRate.getInitObject());
        }
    }

}
