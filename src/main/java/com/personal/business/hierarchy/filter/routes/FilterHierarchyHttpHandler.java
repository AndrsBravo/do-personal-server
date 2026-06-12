package com.personal.business.hierarchy.filter.routes;

import com.personal.business.hierarchy.filter.inputs.FilterHierarchyInput;
import com.personal.business.hierarchy.filter.process.FilterHierarchyProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterHierarchyHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyFilterInput = request.content().as(FilterHierarchyInput.class);
        var hierarchyProcess = FilterHierarchyProcessExecutor.builder().init(hierarchyFilterInput).execute();

        switch (hierarchyProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", hierarchyProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(hierarchyProcess.getResult()));
        }
    }

}
