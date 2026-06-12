package com.personal.business.benefitdeductionrelation.create.routes;

import com.personal.business.benefitdeductionrelation.create.inputs.BenefitDeductionRelationInput;
import com.personal.business.benefitdeductionrelation.create.process.CreateBenefitDeductionRelationProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateBenefitDeductionRelationHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var benefitDeductionRelation = request.content().as(BenefitDeductionRelationInput.class);

        var createBenefitDeductionRelation = CreateBenefitDeductionRelationProcessExecutor.builder()
                .init(benefitDeductionRelation.getBenefitDeductionRelation())
                .execute();
        switch (createBenefitDeductionRelation.state()) {
            case COMPLETED ->
                response.status(Status.CREATED_201).send(createBenefitDeductionRelation.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(createBenefitDeductionRelation.getInitObject());
        }
    }
}
