package com.personal.management.orgstructure.update.routes;

import com.personal.management.orgstructure.create.inputs.OrgStructureInput;
import com.personal.management.orgstructure.update.process.UpdateOrgStructureProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateOrgStructureHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var orgStructure = request.content().as(OrgStructureInput.class);

        var updateOrgStructure = UpdateOrgStructureProcessExecutor.builder()
                .init(orgStructure.getOrgStructure())
                .execute();

        switch (updateOrgStructure.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateOrgStructure.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateOrgStructure.getInitObject());
        }
    }

}
