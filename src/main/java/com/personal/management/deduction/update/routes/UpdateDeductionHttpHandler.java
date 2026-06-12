package com.personal.management.deduction.update.routes;

import com.personal.management.deduction.create.inputs.DeductionInput;
import com.personal.management.deduction.update.process.UpdateDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateDeductionHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var deduction = request.content().as(DeductionInput.class);

        var updateDeduction = UpdateDeductionProcessExecutor.builder()
                .init(deduction.getDeduction())
                .execute();

        switch (updateDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateDeduction.getInitObject());
        }
    }

}
