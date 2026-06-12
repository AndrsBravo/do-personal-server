package com.personal.backoffice.usertype.create.routes;

import com.personal.backoffice.usertype.create.process.CreateUserTypeProcessExecutor;
import com.personal.shared.inputs.BaseTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateUserTypeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var userType = request.content().as(BaseTypeInput.class);

        var createUserType = CreateUserTypeProcessExecutor.builder()
                .init(userType.getType())
                .execute();
        if (createUserType.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createUserType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createUserType.getInitObject());
    }
}
