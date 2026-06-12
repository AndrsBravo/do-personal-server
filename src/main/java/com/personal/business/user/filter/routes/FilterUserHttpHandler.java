package com.personal.business.user.filter.routes;

import com.personal.business.user.filter.inputs.FilterUserInput;
import com.personal.business.user.filter.process.FilterUserProcess;
import com.personal.business.user.filter.process.FilterUserProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterUserHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var filterUser = request.content().as(FilterUserInput.class);

        FilterUserProcess pro = FilterUserProcessExecutor.builder().init(filterUser).execute();

        switch (pro.state()) {
            case ProcessState.COMPLETED ->
                response.status(Status.OK_200).send(Response.success(pro.getResult()));

            case ProcessState.STOP_WITH_ERROR ->
                response.status(Status.INTERNAL_SERVER_ERROR_500).send(Response.error("500", pro.getCurrentLog()));
        }
    }
}
