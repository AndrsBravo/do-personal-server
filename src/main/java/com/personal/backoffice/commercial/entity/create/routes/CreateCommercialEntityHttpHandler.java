package com.personal.backoffice.commercial.entity.create.routes;

import com.personal.backoffice.commercial.entity.create.inputs.CommercialEntityInput;
import com.personal.backoffice.commercial.entity.create.process.CreateCommercialEntityProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateCommercialEntityHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var commercialEntity = request.content().as(CommercialEntityInput.class);

        var createCommercialEntity = CreateCommercialEntityProcessExecutor.builder()
                .init(commercialEntity.getCommercialEntity())
                .execute();
        if (createCommercialEntity.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createCommercialEntity.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createCommercialEntity.getInitObject());
    }
}
