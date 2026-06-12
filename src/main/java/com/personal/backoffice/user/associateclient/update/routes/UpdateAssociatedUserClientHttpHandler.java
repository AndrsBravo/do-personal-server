package com.personal.backoffice.user.associateclient.update.routes;

import com.personal.backoffice.user.associateclient.add.inputs.AssociateUserClientInput;
import com.personal.backoffice.user.associateclient.update.process.UpdateAssociatedUserClientProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateAssociatedUserClientHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var user = request.content().as(AssociateUserClientInput.class);

        var updateUser = UpdateAssociatedUserClientProcessExecutor.builder()
                .init(user.toAssociateUserClient())
                .execute();

        //System.out.println("updateUser state " + updateUser.state());
        switch (updateUser.state()) {

            case ProcessState.COMPLETED ->
                response.status(Status.OK_200).send(updateUser.getInitObject());
            case ProcessState.STOP_WITH_ERROR ->
                response.status(Status.INTERNAL_SERVER_ERROR_500).send(updateUser.getCurrentLog());

            default ->
                response.status(Status.ACCEPTED_202).send(updateUser.getInitObject());
        }
    }

}
