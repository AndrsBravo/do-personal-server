package com.personal.management.orgrelation.filter.routes;

import com.personal.management.orgrelation.filter.inputs.FilterOrgRelationInput;
import com.personal.management.orgrelation.filter.process.FilterOrgRelationProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterOrgRelationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var orgRelationFilterInput = request.content().as(FilterOrgRelationInput.class);
        var orgRelationProcess = FilterOrgRelationProcessExecutor.builder().init(orgRelationFilterInput).execute();

        switch (orgRelationProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", orgRelationProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(orgRelationProcess.getResult()));
        }
    }

}
