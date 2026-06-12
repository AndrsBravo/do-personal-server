package com.personal.management.deductioncategory.update.routes;

import com.personal.management.deductioncategory.create.inputs.DeductionCategoryInput;
import com.personal.management.deductioncategory.update.process.UpdateDeductionCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateDeductionCategoryHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var deductionCategory = request.content().as(DeductionCategoryInput.class);

        var updateDeductionCategory = UpdateDeductionCategoryProcessExecutor.builder()
                .init(deductionCategory.getDeductionCategory())
                .execute();

        switch (updateDeductionCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateDeductionCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateDeductionCategory.getInitObject());
        }
    }

}
