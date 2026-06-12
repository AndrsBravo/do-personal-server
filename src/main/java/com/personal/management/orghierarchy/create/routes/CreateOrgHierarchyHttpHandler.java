package com.personal.management.orghierarchy.create.routes;

import com.personal.management.orghierarchy.create.inputs.OrgHierarchyInput;
import com.personal.management.orghierarchy.create.process.CreateOrgHierarchyProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateOrgHierarchyHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var orgHierarchy = request.content().as(OrgHierarchyInput.class);

        var createOrgHierarchy = CreateOrgHierarchyProcessExecutor.builder()
                .init(orgHierarchy.getOrgHierarchy())
                .execute();
        if (createOrgHierarchy.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createOrgHierarchy.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createOrgHierarchy.getInitObject());
    }
}
