package com.personal.business.orgrelation.create.routes;

import com.personal.business.orgrelation.create.inputs.OrgRelationInput;
import com.personal.business.orgrelation.create.process.CreateOrgRelationProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateOrgRelationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var orgRelation = request.content().as(OrgRelationInput.class);

        var createOrgRelation = CreateOrgRelationProcessExecutor.builder()
                .init(orgRelation.getOrgRelation())
                .execute();
        switch (createOrgRelation.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createOrgRelation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createOrgRelation.getInitObject());
        }
    }
}
