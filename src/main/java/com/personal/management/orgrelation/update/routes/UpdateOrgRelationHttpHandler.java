package com.personal.management.orgrelation.update.routes;

import com.personal.management.orgrelation.create.inputs.OrgRelationInput;
import com.personal.management.orgrelation.update.process.UpdateOrgRelationProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateOrgRelationHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var orgRelation = request.content().as(OrgRelationInput.class);

        var updateOrgRelation = UpdateOrgRelationProcessExecutor.builder()
                .init(orgRelation.getOrgRelation())
                .execute();

        switch (updateOrgRelation.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateOrgRelation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateOrgRelation.getInitObject());
        }
    }

}
