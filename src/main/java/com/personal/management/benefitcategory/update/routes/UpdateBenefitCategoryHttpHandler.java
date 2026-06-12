package com.personal.management.benefitcategory.update.routes;

import com.personal.management.benefitcategory.create.inputs.BenefitCategoryInput;
import com.personal.management.benefitcategory.update.process.UpdateBenefitCategoryProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateBenefitCategoryHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var benefitCategory = request.content().as(BenefitCategoryInput.class);

        var updateBenefitCategory = UpdateBenefitCategoryProcessExecutor.builder()
                .init(benefitCategory.getBenefitCategory())
                .execute();

        switch (updateBenefitCategory.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateBenefitCategory.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateBenefitCategory.getInitObject());
        }
    }

}
