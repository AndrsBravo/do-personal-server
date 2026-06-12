package com.personal.management.orgstructure.create.routes;

import com.personal.management.orgstructure.create.inputs.OrgStructureInput;
import com.personal.management.orgstructure.create.process.CreateOrgStructureProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateOrgStructureHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var orgStructure = request.content().as(OrgStructureInput.class);

        var createOrgStructure = CreateOrgStructureProcessExecutor.builder()
                .init(orgStructure.getOrgStructure())
                .execute();
        switch (createOrgStructure.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createOrgStructure.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createOrgStructure.getInitObject());
        }
    }
}
