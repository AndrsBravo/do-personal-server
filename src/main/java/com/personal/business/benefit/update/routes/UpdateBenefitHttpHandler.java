package com.personal.business.benefit.update.routes;

import com.personal.business.benefit.create.inputs.BenefitInput;
import com.personal.business.benefit.update.process.UpdateBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateBenefitHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var benefit = request.content().as(BenefitInput.class);

        var updateBenefit = UpdateBenefitProcessExecutor.builder()
                .init(benefit.getBenefit())
                .execute();

        switch (updateBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateBenefit.getInitObject());
        }
    }

}
