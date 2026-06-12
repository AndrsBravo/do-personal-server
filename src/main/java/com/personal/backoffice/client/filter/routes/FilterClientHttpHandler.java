package com.personal.backoffice.client.filter.routes;

import com.personal.backoffice.client.filter.inputs.FilterClientInput;
import com.personal.backoffice.client.filter.process.FilterClientProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterClientHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {

        var clientsFilterInput = request.content().as(FilterClientInput.class);
        var clientProcess = FilterClientProcessExecutor.builder().init(clientsFilterInput).execute();
        if (clientProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", clientProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(clientProcess.getResult()));
    }

}
