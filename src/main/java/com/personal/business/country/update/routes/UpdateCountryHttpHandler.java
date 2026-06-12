package com.personal.business.country.update.routes;

import com.personal.business.country.create.inputs.CountryInput;
import com.personal.business.country.update.process.UpdateCountryProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateCountryHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var country = request.content().as(CountryInput.class);

        var updateCountry = UpdateCountryProcessExecutor.builder()
                .init(country.getCountry())
                .execute();

        if (updateCountry.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updateCountry.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updateCountry.getInitObject());
    }

}
