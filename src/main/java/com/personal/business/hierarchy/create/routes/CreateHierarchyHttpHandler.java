package com.personal.business.hierarchy.create.routes;

import com.personal.business.hierarchy.create.inputs.HierarchyInput;
import com.personal.business.hierarchy.create.process.CreateHierarchyProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateHierarchyHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchy = request.content().as(HierarchyInput.class);

        var createHierarchy = CreateHierarchyProcessExecutor.builder()
                .init(hierarchy.getHierarchy())
                .execute();
        if (createHierarchy.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createHierarchy.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createHierarchy.getInitObject());
    }
}
