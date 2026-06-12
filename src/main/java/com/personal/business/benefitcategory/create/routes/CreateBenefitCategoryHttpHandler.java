package com.personal.business.benefitcategory.create.routes;

import com.personal.business.benefitcategory.create.inputs.BenefitCategoryInput;
import com.personal.business.benefitcategory.create.process.CreateBenefitCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateBenefitCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefitCategory = request.content().as(BenefitCategoryInput.class);

        var createBenefitCategory = CreateBenefitCategoryProcessExecutor.builder()
                .init(benefitCategory.getBenefitCategory())
                .execute();
        switch (createBenefitCategory.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createBenefitCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createBenefitCategory.getInitObject());
        }
    }
}
