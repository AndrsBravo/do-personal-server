package com.personal.backoffice.user.associatebusiness.filter.routes;

import com.personal.backoffice.user.associatebusiness.filter.inputs.FilterAssociatedUserBusinessInput;
import com.personal.backoffice.user.associatebusiness.filter.process.FilterAssociatedUserBusinessProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterAssociatedUserBusinessHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {

        var associatedUserBusiness = request.content().as(FilterAssociatedUserBusinessInput.class);

        var clientProcess = FilterAssociatedUserBusinessProcessExecutor.builder()
                .init(associatedUserBusiness)
                .execute();

        if (clientProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", clientProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(clientProcess.getResult()));

    }
}
