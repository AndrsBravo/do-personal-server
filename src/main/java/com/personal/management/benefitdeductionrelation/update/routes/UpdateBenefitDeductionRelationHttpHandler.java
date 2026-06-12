package com.personal.management.benefitdeductionrelation.update.routes;

import com.personal.management.benefitdeductionrelation.create.inputs.BenefitDeductionRelationInput;
import com.personal.management.benefitdeductionrelation.update.process.UpdateBenefitDeductionRelationProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateBenefitDeductionRelationHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var benefitDeductionRelation = request.content().as(BenefitDeductionRelationInput.class);

        var updateBenefitDeductionRelation = UpdateBenefitDeductionRelationProcessExecutor.builder()
                .init(benefitDeductionRelation.getBenefitDeductionRelation())
                .execute();

        switch (updateBenefitDeductionRelation.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateBenefitDeductionRelation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateBenefitDeductionRelation.getInitObject());
        }
    }

}
