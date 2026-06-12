package com.personal.business.payrollemployee.update.routes;

import com.personal.business.payrollemployee.create.inputs.PayrollEmployeeInput;
import com.personal.business.payrollemployee.update.process.UpdatePayrollEmployeeProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollEmployeeHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollEmployee = request.content().as(PayrollEmployeeInput.class);

        var updatePayrollEmployee = UpdatePayrollEmployeeProcessExecutor.builder()
                .init(payrollEmployee.getPayrollEmployee())
                .execute();

        switch (updatePayrollEmployee.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollEmployee.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollEmployee.getInitObject());
        }
    }

}
