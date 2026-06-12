package com.personal.backoffice.userrelation.update.routes;

import com.personal.backoffice.userrelation.create.inputs.UserRelationInput;
import com.personal.backoffice.userrelation.update.process.UpdateUserRelationProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateUserRelationHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var userRelation = request.content().as(UserRelationInput.class);

        var updateUserRelation = UpdateUserRelationProcessExecutor.builder()
                .init(userRelation.getUserRelation())
                .execute();

        if (updateUserRelation.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateUserRelation.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateUserRelation.getInitObject());
    }

}
