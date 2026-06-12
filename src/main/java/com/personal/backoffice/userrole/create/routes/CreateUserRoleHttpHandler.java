package com.personal.backoffice.userrole.create.routes;

import com.personal.backoffice.userrole.create.inputs.UserRoleInput;
import com.personal.backoffice.userrole.create.process.CreateUserRoleProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateUserRoleHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var userRole = request.content().as(UserRoleInput.class);

        var createUserRole = CreateUserRoleProcessExecutor.builder()
                .init(userRole.getUserRole())
                .execute();
        if (createUserRole.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createUserRole.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createUserRole.getInitObject());
    }
}
