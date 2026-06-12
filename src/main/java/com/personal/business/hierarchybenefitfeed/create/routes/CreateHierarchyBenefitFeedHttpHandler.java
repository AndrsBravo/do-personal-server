package com.personal.business.hierarchybenefitfeed.create.routes;

import com.personal.business.hierarchybenefitfeed.create.inputs.HierarchyBenefitFeedInput;
import com.personal.business.hierarchybenefitfeed.create.process.CreateHierarchyBenefitFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateHierarchyBenefitFeedHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyBenefitFeed = request.content().as(HierarchyBenefitFeedInput.class);

        var createHierarchyBenefitFeed = CreateHierarchyBenefitFeedProcessExecutor.builder()
                .init(hierarchyBenefitFeed.getHierarchyBenefitFeed())
                .execute();
        switch (createHierarchyBenefitFeed.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createHierarchyBenefitFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createHierarchyBenefitFeed.getInitObject());
        }
    }
}
