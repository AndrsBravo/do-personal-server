package com.personal.backoffice.user.associateclient.filter.routes;

import com.personal.backoffice.user.associateclient.filter.inputs.FilterAssociatedUserClientInput;
import com.personal.backoffice.user.associateclient.filter.process.FilterAssociatedUserClientProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterAssociatedUserClientHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {

        var associatedUserClient = request.content().as(FilterAssociatedUserClientInput.class);

        var clientProcess = FilterAssociatedUserClientProcessExecutor.builder()
                .init(associatedUserClient)
                .execute();

        if (clientProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", clientProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(clientProcess.getResult()));

    }
}
