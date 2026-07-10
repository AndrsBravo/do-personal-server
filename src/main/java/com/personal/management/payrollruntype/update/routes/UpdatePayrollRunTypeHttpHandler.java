package com.personal.management.payrollruntype.update.routes;

import com.personal.backoffice.shared.inputs.TypeInput;
import com.personal.management.payrollruntype.update.process.UpdatePayrollRunTypeProcessExecutor;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollRunTypeHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollRunType = request.content().as(TypeInput.class);

        var updatePayrollRunType = UpdatePayrollRunTypeProcessExecutor.builder()
                .init(payrollRunType.getType())
                .execute();

        if (updatePayrollRunType.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(updatePayrollRunType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(updatePayrollRunType.getInitObject());
    }

}
