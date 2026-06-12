package com.personal.backoffice.userrelation.create.routes;

import com.personal.backoffice.userrelation.create.inputs.UserRelationInput;
import com.personal.backoffice.userrelation.create.process.CreateUserRelationProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateUserRelationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var userRelation = request.content().as(UserRelationInput.class);

        var createUserRelation = CreateUserRelationProcessExecutor.builder()
                .init(userRelation.getUserRelation())
                .execute();
        if (createUserRelation.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createUserRelation.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createUserRelation.getInitObject());
    }
}
