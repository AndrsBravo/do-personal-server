package com.personal.management.country.filter.routes;

import com.personal.management.country.filter.inputs.FilterCountryInput;
import com.personal.management.country.filter.process.FilterCountryProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterCountryHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var countriesFilterInput = request.content().as(FilterCountryInput.class);
        var countryProcess = FilterCountryProcessExecutor.builder().init(countriesFilterInput).execute();
        if (countryProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", countryProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(countryProcess.getResult()));
    }

}
