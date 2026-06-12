package com.personal.management.orghierarchy.update.routes;

import com.personal.management.orghierarchy.create.inputs.OrgHierarchyInput;
import com.personal.management.orghierarchy.update.process.UpdateOrgHierarchyProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateOrgHierarchyHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var orgHierarchy = request.content().as(OrgHierarchyInput.class);

        var updateOrgHierarchy = UpdateOrgHierarchyProcessExecutor.builder()
                .init(orgHierarchy.getOrgHierarchy())
                .execute();

        switch (updateOrgHierarchy.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateOrgHierarchy.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateOrgHierarchy.getInitObject());
        }
    }

}
