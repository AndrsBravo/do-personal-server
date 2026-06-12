package com.personal.business.deduction.filter.routes;

import com.personal.business.deduction.filter.inputs.FilterDeductionInput;
import com.personal.business.deduction.filter.process.FilterDeductionProcessExecutor;
import com.personal.shared.http.Response;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterDeductionHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var deductionFilterInput = request.content().as(FilterDeductionInput.class);
        var deductionProcess = FilterDeductionProcessExecutor.builder().init(deductionFilterInput).execute();

        switch (deductionProcess.state()) {
            case STOP_WITH_ERROR ->
                response.status(Status.NO_CONTENT_204).send(Response.error("204", deductionProcess.getCurrentLog()));

            default ->
                response.status(Status.OK_200).send(Response.success(deductionProcess.getResult()));
        }
    }

}
