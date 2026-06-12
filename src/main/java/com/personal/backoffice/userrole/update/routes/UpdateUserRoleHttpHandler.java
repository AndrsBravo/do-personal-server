package com.personal.backoffice.userrole.update.routes;

import com.personal.backoffice.userrole.create.inputs.UserRoleInput;
import com.personal.backoffice.userrole.update.process.UpdateUserRoleProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateUserRoleHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var userRole = request.content().as(UserRoleInput.class);

        var updateUserRole = UpdateUserRoleProcessExecutor.builder()
                .init(userRole.getUserRole())
                .execute();

        if (updateUserRole.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateUserRole.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateUserRole.getInitObject());
    }

}
