package com.personal.business.hierarchydeductionfeed.update.routes;

import com.personal.business.hierarchydeductionfeed.create.inputs.HierarchyDeductionFeedInput;
import com.personal.business.hierarchydeductionfeed.update.process.UpdateHierarchyDeductionFeedProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateHierarchyDeductionFeedHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var hierarchyDeductionFeed = request.content().as(HierarchyDeductionFeedInput.class);

        var updateHierarchyDeductionFeed = UpdateHierarchyDeductionFeedProcessExecutor.builder()
                .init(hierarchyDeductionFeed.getHierarchyDeductionFeed())
                .execute();

        switch (updateHierarchyDeductionFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateHierarchyDeductionFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateHierarchyDeductionFeed.getInitObject());
        }
    }

}
