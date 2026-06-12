package com.personal.business.structure.update.routes;

import com.personal.business.structure.create.inputs.StructureInput;
import com.personal.business.structure.update.process.UpdateStructureProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateStructureHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var structure = request.content().as(StructureInput.class);

        var updateStructure = UpdateStructureProcessExecutor.builder()
                .init(structure.getStructure())
                .execute();

        switch (updateStructure.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateStructure.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateStructure.getInitObject());
        }
    }

}
