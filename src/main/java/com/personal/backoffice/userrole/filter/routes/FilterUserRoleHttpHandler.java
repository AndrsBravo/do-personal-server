package com.personal.backoffice.userrole.filter.routes;

import com.personal.backoffice.userrole.filter.inputs.FilterUserRoleInput;
import com.personal.backoffice.userrole.filter.process.FilterUserRoleProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterUserRoleHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var userRolesFilterInput = request.content().as(FilterUserRoleInput.class);
        var userRoleProcess = FilterUserRoleProcessExecutor.builder().init(userRolesFilterInput).execute();
        if (userRoleProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", userRoleProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(userRoleProcess.getResult()));
    }

}
