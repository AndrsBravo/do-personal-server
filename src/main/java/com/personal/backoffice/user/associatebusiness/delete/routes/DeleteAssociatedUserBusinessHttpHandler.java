package com.personal.backoffice.user.associatebusiness.delete.routes;

import com.personal.backoffice.user.associatebusiness.add.inputs.AssociateUserBusinessInput;
import com.personal.backoffice.user.associatebusiness.delete.process.DeleteAssociatedUserBusinessProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteAssociatedUserBusinessHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var associatedUserBusinessInput = request.content().as(AssociateUserBusinessInput.class);

        var deleteClient = DeleteAssociatedUserBusinessProcessExecutor.builder()
                .init(associatedUserBusinessInput.toAssociateUserBusiness())
                .execute();

        switch (deleteClient.state()) {
            case ProcessState.COMPLETED ->
                response.status(Status.OK_200).send(deleteClient.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteClient.getInitObject());
        }
    }

}
