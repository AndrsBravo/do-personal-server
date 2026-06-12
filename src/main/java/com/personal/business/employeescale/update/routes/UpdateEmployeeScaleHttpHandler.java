package com.personal.business.employeescale.update.routes;

import com.personal.business.employeescale.create.inputs.EmployeeScaleInput;
import com.personal.business.employeescale.update.process.UpdateEmployeeScaleProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateEmployeeScaleHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var employeeScale = request.content().as(EmployeeScaleInput.class);

        var updateEmployeeScale = UpdateEmployeeScaleProcessExecutor.builder()
                .init(employeeScale.getEmployeeScale())
                .execute();

        switch (updateEmployeeScale.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateEmployeeScale.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateEmployeeScale.getInitObject());
        }
    }

}
