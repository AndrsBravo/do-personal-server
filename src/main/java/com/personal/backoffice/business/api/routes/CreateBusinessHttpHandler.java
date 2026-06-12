package com.personal.backoffice.business.api.routes;

import com.personal.backoffice.business.api.inputs.BusinessInput;
import com.personal.backoffice.business.process.create.CreateBusinessProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateBusinessHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var business = request.content().as(BusinessInput.class);

        System.out.println("El Country en el business  " + business.getBusiness().getCountry());
        var createBusiness = CreateBusinessProcessExecutor.builder()
                .init(business.getBusiness())
                .execute();
        if (createBusiness.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createBusiness.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createBusiness.getInitObject());
    }
}
