package com.personal.backoffice.user.update.routes;

import com.personal.backoffice.user.create.inputs.UserInput;
import com.personal.backoffice.user.update.process.EditUserProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateUserHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var user = request.content().as(UserInput.class);

        var updateUser = EditUserProcessExecutor.builder()
                .init(user.getUser())
                .execute();

        //System.out.println("updateUser state " + updateUser.state());
        if (updateUser.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.INTERNAL_SERVER_ERROR_500).send(updateUser.getCurrentLog());
            return;
        }

        if (updateUser.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateUser.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateUser.getInitObject());
    }

}
