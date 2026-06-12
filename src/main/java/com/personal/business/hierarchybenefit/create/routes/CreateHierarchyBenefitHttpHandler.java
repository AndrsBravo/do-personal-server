package com.personal.business.hierarchybenefit.create.routes;

import com.personal.business.hierarchybenefit.create.inputs.HierarchyBenefitInput;
import com.personal.business.hierarchybenefit.create.process.CreateHierarchyBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateHierarchyBenefitHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var hierarchyBenefit = request.content().as(HierarchyBenefitInput.class);

        var createHierarchyBenefit = CreateHierarchyBenefitProcessExecutor.builder()
                .init(hierarchyBenefit.getHierarchyBenefit())
                .execute();
        switch (createHierarchyBenefit.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createHierarchyBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createHierarchyBenefit.getInitObject());
        }
    }
}
