package com.personal.business.employeededuction.update.routes;

import com.personal.business.employeededuction.create.inputs.EmployeeDeductionInput;
import com.personal.business.employeededuction.update.process.UpdateEmployeeDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateEmployeeDeductionHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var employeeDeduction = request.content().as(EmployeeDeductionInput.class);

        var updateEmployeeDeduction = UpdateEmployeeDeductionProcessExecutor.builder()
                .init(employeeDeduction.getEmployeeDeduction())
                .execute();

        switch (updateEmployeeDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateEmployeeDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateEmployeeDeduction.getInitObject());
        }
    }

}
