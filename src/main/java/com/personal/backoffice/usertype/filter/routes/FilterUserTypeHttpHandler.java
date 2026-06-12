package com.personal.backoffice.usertype.filter.routes;

import com.personal.backoffice.usertype.filter.process.FilterUserTypeProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterUserTypeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var userTypesFilterInput = request.content().as(FilterTypeInput.class);
        var userTypeProcess = FilterUserTypeProcessExecutor.builder().init(userTypesFilterInput).execute();
        if (userTypeProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", userTypeProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(userTypeProcess.getResult()));
    }

}
