package com.personal.business.hierarchydeduction.update.routes;

import com.personal.business.hierarchydeduction.create.inputs.HierarchyDeductionInput;
import com.personal.business.hierarchydeduction.update.process.UpdateHierarchyDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateHierarchyDeductionHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var hierarchyDeduction = request.content().as(HierarchyDeductionInput.class);

        var updateHierarchyDeduction = UpdateHierarchyDeductionProcessExecutor.builder()
                .init(hierarchyDeduction.getHierarchyDeduction())
                .execute();

        switch (updateHierarchyDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateHierarchyDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateHierarchyDeduction.getInitObject());
        }
    }

}
