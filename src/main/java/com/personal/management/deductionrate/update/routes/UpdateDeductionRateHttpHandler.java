package com.personal.management.deductionrate.update.routes;

import com.personal.management.deductionrate.create.inputs.DeductionRateInput;
import com.personal.management.deductionrate.update.process.UpdateDeductionRateProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateDeductionRateHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var deductionRate = request.content().as(DeductionRateInput.class);

        var updateDeductionRate = UpdateDeductionRateProcessExecutor.builder()
                .init(deductionRate.getDeductionRate())
                .execute();

        switch (updateDeductionRate.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateDeductionRate.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateDeductionRate.getInitObject());
        }
    }

}
