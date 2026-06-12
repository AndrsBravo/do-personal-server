package com.personal.management.origincategory.filter.routes;

import com.personal.management.origincategory.filter.inputs.FilterOriginCategoryInput;
import com.personal.management.origincategory.filter.process.FilterOriginCategoryProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterOriginCategoryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var originCategoryFilterInput = request.content().as(FilterOriginCategoryInput.class);
        var originCategoryProcess = FilterOriginCategoryProcessExecutor.builder().init(originCategoryFilterInput).execute();

        switch (originCategoryProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", originCategoryProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(originCategoryProcess.getResult()));
        }
    }

}
