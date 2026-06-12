package com.personal.backoffice.business.api.routes;

import com.personal.backoffice.business.api.inputs.BusinessInput;
import com.personal.backoffice.business.process.update.UpdateBusinessProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateBusinessHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var business = request.content().as(BusinessInput.class);

        var updateBusiness = UpdateBusinessProcessExecutor.builder()
                .init(business.getBusiness())
                .execute();

        if (updateBusiness.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateBusiness.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateBusiness.getInitObject());
    }

}
