package com.personal.backoffice.userrelation.filter.routes;

import com.personal.backoffice.userrelation.filter.inputs.FilterUserRelationInput;
import com.personal.backoffice.userrelation.filter.process.FilterUserRelationProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterUserRelationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var userRelationsFilterInput = request.content().as(FilterUserRelationInput.class);
        var userRelationProcess = FilterUserRelationProcessExecutor.builder().init(userRelationsFilterInput).execute();
        if (userRelationProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", userRelationProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(userRelationProcess.getResult()));
    }

}
