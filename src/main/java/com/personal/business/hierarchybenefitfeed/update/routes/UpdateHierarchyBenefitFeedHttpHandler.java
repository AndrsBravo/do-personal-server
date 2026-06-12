package com.personal.business.hierarchybenefitfeed.update.routes;

import com.personal.business.hierarchybenefitfeed.create.inputs.HierarchyBenefitFeedInput;
import com.personal.business.hierarchybenefitfeed.update.process.UpdateHierarchyBenefitFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateHierarchyBenefitFeedHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var hierarchyBenefitFeed = request.content().as(HierarchyBenefitFeedInput.class);

        var updateHierarchyBenefitFeed = UpdateHierarchyBenefitFeedProcessExecutor.builder()
                .init(hierarchyBenefitFeed.getHierarchyBenefitFeed())
                .execute();

        switch (updateHierarchyBenefitFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateHierarchyBenefitFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateHierarchyBenefitFeed.getInitObject());
        }
    }

}
