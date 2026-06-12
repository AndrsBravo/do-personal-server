package com.personal.business.structure.create.routes;

import com.personal.business.structure.create.inputs.StructureInput;
import com.personal.business.structure.create.process.CreateStructureProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateStructureHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var structure = request.content().as(StructureInput.class);

        var createStructure = CreateStructureProcessExecutor.builder()
                .init(structure.getStructure())
                .execute();
        switch (createStructure.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createStructure.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createStructure.getInitObject());
        }
    }
}
