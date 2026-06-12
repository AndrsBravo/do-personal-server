package com.personal.business.hierarchydeductionfeed.create.routes;

import com.personal.business.hierarchydeductionfeed.create.inputs.HierarchyDeductionFeedInput;
import com.personal.business.hierarchydeductionfeed.create.process.CreateHierarchyDeductionFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateHierarchyDeductionFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyDeductionFeed = request.content().as(HierarchyDeductionFeedInput.class);

        var createHierarchyDeductionFeed = CreateHierarchyDeductionFeedProcessExecutor.builder()
                .init(hierarchyDeductionFeed.getHierarchyDeductionFeed())
                .execute();
        switch (createHierarchyDeductionFeed.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createHierarchyDeductionFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createHierarchyDeductionFeed.getInitObject());
        }
    }
}
