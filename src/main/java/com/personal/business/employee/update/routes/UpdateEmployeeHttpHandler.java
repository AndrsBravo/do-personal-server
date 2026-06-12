package com.personal.business.employee.update.routes;

import com.personal.business.employee.create.inputs.EmployeeInput;
import com.personal.business.employee.update.process.UpdateEmployeeProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateEmployeeHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var employee = request.content().as(EmployeeInput.class);

        var updateEmployee = UpdateEmployeeProcessExecutor.builder()
                .init(employee.getEmployee())
                .execute();

        switch (updateEmployee.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateEmployee.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateEmployee.getInitObject());
        }
    }

}
