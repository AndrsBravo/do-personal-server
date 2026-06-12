package com.personal.backoffice.user.create.routes;

import com.personal.backoffice.user.create.inputs.UserInput;
import com.personal.backoffice.user.create.process.CreateUserProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateUserHttpHandler {

    private final CreateUserProcessExecutor createUserProcessExecutor;

    public CreateUserHttpHandler() {
        this.createUserProcessExecutor = new CreateUserProcessExecutor();
    }

    public void Post(ServerRequest request, ServerResponse response) {

        var userInput = request.content().as(UserInput.class);

        var create = createUserProcessExecutor
                .init(userInput.getUser())
                .execute();

        if (create.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.INTERNAL_SERVER_ERROR_500).send(Response.error("500", create.getCurrentLog()));
            return;
        }

        if (create.state() == ProcessState.STOPPED) {
            response.status(Status.CREATED_201).send(Response.created(create.getInitObject()));
            return;
        }
        response.status(Status.CREATED_201).send(Response.created(create.getInitObject()));

    }
}
