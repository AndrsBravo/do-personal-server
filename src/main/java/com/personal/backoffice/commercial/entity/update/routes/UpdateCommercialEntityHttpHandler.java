package com.personal.backoffice.commercial.entity.update.routes;

import com.personal.backoffice.commercial.entity.create.inputs.CommercialEntityInput;
import com.personal.backoffice.commercial.entity.update.process.UpdateCommercialEntityProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateCommercialEntityHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var commercialEntity = request.content().as(CommercialEntityInput.class);

        var updateCommercialEntity = UpdateCommercialEntityProcessExecutor.builder()
                .init(commercialEntity.getCommercialEntity())
                .execute();

        if (updateCommercialEntity.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateCommercialEntity.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateCommercialEntity.getInitObject());
    }

}
