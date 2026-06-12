package com.personal.business.payrollruntype.create.routes;

import com.personal.business.payrollruntype.create.process.CreatePayrollRunTypeProcessExecutor;
import com.personal.business.shared.inputs.TypeInput;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class CreatePayrollRunTypeHttpHandler {

    public void Post(ServerRequest request, ServerResponse response) {
        var payrollRunType = request.content().as(TypeInput.class);

        var createPayrollRunType = CreatePayrollRunTypeProcessExecutor.builder()
                .init(payrollRunType.getType())
                .execute();
        if (createPayrollRunType.state() == ProcessState.COMPLETED) {
            response.status(Status.CREATED_201).send(createPayrollRunType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(createPayrollRunType.getInitObject());
    }
}
