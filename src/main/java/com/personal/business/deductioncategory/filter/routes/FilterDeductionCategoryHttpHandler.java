package com.personal.business.deductioncategory.filter.routes;

import com.personal.business.deductioncategory.filter.inputs.FilterDeductionCategoryInput;
import com.personal.business.deductioncategory.filter.process.FilterDeductionCategoryProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterDeductionCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var deductionCategoryFilterInput = request.content().as(FilterDeductionCategoryInput.class);
        var deductionCategoryProcess = FilterDeductionCategoryProcessExecutor.builder().init(deductionCategoryFilterInput).execute();

        switch (deductionCategoryProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", deductionCategoryProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(deductionCategoryProcess.getResult()));
        }
    }

}
