package com.personal.business.hierarchydeduction.create.routes;

import com.personal.business.hierarchydeduction.create.inputs.HierarchyDeductionInput;
import com.personal.business.hierarchydeduction.create.process.CreateHierarchyDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateHierarchyDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyDeduction = request.content().as(HierarchyDeductionInput.class);

        var createHierarchyDeduction = CreateHierarchyDeductionProcessExecutor.builder()
                .init(hierarchyDeduction.getHierarchyDeduction())
                .execute();
        switch (createHierarchyDeduction.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createHierarchyDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createHierarchyDeduction.getInitObject());
        }
    }
}
