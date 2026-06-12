package com.personal.business.deductioncategory.create.routes;

import com.personal.business.deductioncategory.create.inputs.DeductionCategoryInput;
import com.personal.business.deductioncategory.create.process.CreateDeductionCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateDeductionCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var deductionCategory = request.content().as(DeductionCategoryInput.class);

        var createDeductionCategory = CreateDeductionCategoryProcessExecutor.builder()
                .init(deductionCategory.getDeductionCategory())
                .execute();
        switch (createDeductionCategory.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createDeductionCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createDeductionCategory.getInitObject());
        }
    }
}
