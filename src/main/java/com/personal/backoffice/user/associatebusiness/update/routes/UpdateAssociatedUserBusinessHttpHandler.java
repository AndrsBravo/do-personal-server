package com.personal.backoffice.user.associatebusiness.update.routes;

import com.personal.backoffice.user.associatebusiness.add.inputs.AssociateUserBusinessInput;
import com.personal.backoffice.user.associatebusiness.update.process.UpdateAssociatedUserBusinessProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateAssociatedUserBusinessHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var user = request.content().as(AssociateUserBusinessInput.class);

        var updateUser = UpdateAssociatedUserBusinessProcessExecutor.builder()
                .init(user.toAssociateUserBusiness())
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
