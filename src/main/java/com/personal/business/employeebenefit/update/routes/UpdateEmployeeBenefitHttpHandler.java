package com.personal.business.employeebenefit.update.routes;

import com.personal.business.employeebenefit.create.inputs.EmployeeBenefitInput;
import com.personal.business.employeebenefit.update.process.UpdateEmployeeBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdateEmployeeBenefitHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var employeeBenefit = request.content().as(EmployeeBenefitInput.class);

        var updateEmployeeBenefit = UpdateEmployeeBenefitProcessExecutor.builder()
                .init(employeeBenefit.getEmployeeBenefit())
                .execute();

        switch (updateEmployeeBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updateEmployeeBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updateEmployeeBenefit.getInitObject());
        }
    }

}
