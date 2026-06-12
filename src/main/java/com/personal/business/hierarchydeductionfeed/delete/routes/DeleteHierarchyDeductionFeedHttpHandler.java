package com.personal.business.hierarchydeductionfeed.delete.routes;

import com.personal.business.hierarchydeductionfeed.delete.process.DeleteHierarchyDeductionFeedProcessExecutor;
import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteHierarchyDeductionFeedHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var hierarchyDeductionFeed = new HierarchyDeductionFeed(id);

        var deleteHierarchyDeductionFeed = DeleteHierarchyDeductionFeedProcessExecutor.builder()
                .init(hierarchyDeductionFeed)
                .execute();

        switch (deleteHierarchyDeductionFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteHierarchyDeductionFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteHierarchyDeductionFeed.getInitObject());
        }
    }

}
