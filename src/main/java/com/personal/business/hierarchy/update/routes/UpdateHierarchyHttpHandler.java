package com.personal.business.hierarchy.update.routes;

import com.personal.business.hierarchy.create.inputs.HierarchyInput;
import com.personal.business.hierarchy.update.process.UpdateHierarchyProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateHierarchyHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var hierarchy = request.content().as(HierarchyInput.class);

        var updateHierarchy = UpdateHierarchyProcessExecutor.builder()
                .init(hierarchy.getHierarchy())
                .execute();

        switch (updateHierarchy.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateHierarchy.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateHierarchy.getInitObject());
        }
    }

}
