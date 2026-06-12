package com.personal.backoffice.country.create.routes;

import com.personal.backoffice.country.create.inputs.CountryInput;
import com.personal.backoffice.country.create.process.CreateCountryProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreateCountryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var country = request.content().as(CountryInput.class);

        var createCountry = CreateCountryProcessExecutor.builder()
                .init(country.getCountry())
                .execute();
        if (createCountry.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createCountry.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createCountry.getInitObject());
    }
}
