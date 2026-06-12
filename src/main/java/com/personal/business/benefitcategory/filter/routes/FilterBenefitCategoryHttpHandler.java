package com.personal.business.benefitcategory.filter.routes;

import com.personal.business.benefitcategory.filter.inputs.FilterBenefitCategoryInput;
import com.personal.business.benefitcategory.filter.process.FilterBenefitCategoryProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterBenefitCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefitCategoryFilterInput = request.content().as(FilterBenefitCategoryInput.class);
        var benefitCategoryProcess = FilterBenefitCategoryProcessExecutor.builder().init(benefitCategoryFilterInput).execute();

        switch (benefitCategoryProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", benefitCategoryProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(benefitCategoryProcess.getResult()));
        }
    }

}
