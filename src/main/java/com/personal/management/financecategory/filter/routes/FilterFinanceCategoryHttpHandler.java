package com.personal.management.financecategory.filter.routes;

import com.personal.management.financecategory.filter.inputs.FilterFinanceCategoryInput;
import com.personal.management.financecategory.filter.process.FilterFinanceCategoryProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterFinanceCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var financeCategoryFilterInput = request.content().as(FilterFinanceCategoryInput.class);
        var financeCategoryProcess = FilterFinanceCategoryProcessExecutor.builder().init(financeCategoryFilterInput).execute();
        switch (financeCategoryProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", financeCategoryProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(financeCategoryProcess.getResult()));
        }
    }

}
