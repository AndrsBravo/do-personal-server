package com.personal.business.hierarchybenefitfeed.delete.routes;

import com.personal.business.hierarchybenefitfeed.delete.process.DeleteHierarchyBenefitFeedProcessExecutor;
import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteHierarchyBenefitFeedHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var hierarchyBenefitFeed = new HierarchyBenefitFeed(id);

        var deleteHierarchyBenefitFeed = DeleteHierarchyBenefitFeedProcessExecutor.builder()
                .init(hierarchyBenefitFeed)
                .execute();

        switch (deleteHierarchyBenefitFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteHierarchyBenefitFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteHierarchyBenefitFeed.getInitObject());
        }
    }

}
