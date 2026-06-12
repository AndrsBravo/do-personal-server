package com.personal.business.hierarchybenefit.update.routes;

import com.personal.business.hierarchybenefit.create.inputs.HierarchyBenefitInput;
import com.personal.business.hierarchybenefit.update.process.UpdateHierarchyBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateHierarchyBenefitHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var hierarchyBenefit = request.content().as(HierarchyBenefitInput.class);

        var updateHierarchyBenefit = UpdateHierarchyBenefitProcessExecutor.builder()
                .init(hierarchyBenefit.getHierarchyBenefit())
                .execute();

        switch (updateHierarchyBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateHierarchyBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateHierarchyBenefit.getInitObject());
        }
    }

}
