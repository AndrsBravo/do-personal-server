package com.personal.business.orghierarchy.filter.routes;

import com.personal.business.orghierarchy.filter.inputs.FilterOrgHierarchyInput;
import com.personal.business.orghierarchy.filter.process.FilterOrgHierarchyProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterOrgHierarchyHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var orgHierarchyFilterInput = request.content().as(FilterOrgHierarchyInput.class);
        var orgHierarchyProcess = FilterOrgHierarchyProcessExecutor.builder().init(orgHierarchyFilterInput).execute();

        switch (orgHierarchyProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", orgHierarchyProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(orgHierarchyProcess.getResult()));
        }
    }

}
