package com.personal.backoffice.commercial.plandetail.filter.routes;

import com.personal.backoffice.commercial.plandetail.filter.inputs.FilterCommercialPlanDetailInput;
import com.personal.backoffice.commercial.plandetail.filter.process.FilterCommercialPlanDetailProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterCommercialPlanDetailHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var commercialPlanFilterInput = request.content().as(FilterCommercialPlanDetailInput.class);
        var commercialPlanProcess = FilterCommercialPlanDetailProcessExecutor.builder().init(commercialPlanFilterInput).execute();
        if (commercialPlanProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", commercialPlanProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(commercialPlanProcess.getResult()));
    }

}
