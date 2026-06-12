package com.personal.backoffice.usertype.update.routes;

import com.personal.backoffice.usertype.update.process.UpdateUserTypeProcessExecutor;
import com.personal.shared.inputs.BaseTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateUserTypeHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var userType = request.content().as(BaseTypeInput.class);

        var updateUserType = UpdateUserTypeProcessExecutor.builder()
                .init(userType.getType())
                .execute();

        if (updateUserType.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateUserType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateUserType.getInitObject());
    }

}
