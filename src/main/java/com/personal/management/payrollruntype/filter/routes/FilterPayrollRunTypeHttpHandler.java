package com.personal.management.payrollruntype.filter.routes;

import com.personal.management.payrollruntype.filter.process.FilterPayrollRunTypeProcessExecutor;
import com.personal.shared.http.Response;
import com.personal.shared.inputs.FilterTypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class FilterPayrollRunTypeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunTypesFilterInput = request.content().as(FilterTypeInput.class);
        var payrollRunTypeProcess = FilterPayrollRunTypeProcessExecutor.builder().init(payrollRunTypesFilterInput).execute();
        if (payrollRunTypeProcess.state() == ProcessState.STOP_WITH_ERROR) {
            response.status(Status.NO_CONTENT_204).send(Response.error("204", payrollRunTypeProcess.getCurrentLog()));
            return;
        }
        response.status(Status.OK_200).send(Response.success(payrollRunTypeProcess.getResult()));
    }

}
