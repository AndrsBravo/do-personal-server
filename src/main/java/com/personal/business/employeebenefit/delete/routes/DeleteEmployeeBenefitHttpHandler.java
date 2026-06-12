package com.personal.business.employeebenefit.delete.routes;

import com.personal.business.employeebenefit.delete.process.DeleteEmployeeBenefitProcessExecutor;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteEmployeeBenefitHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var employeeBenefit = new EmployeeBenefit(id);

        var deleteEmployeeBenefit = DeleteEmployeeBenefitProcessExecutor.builder()
                .init(employeeBenefit)
                .execute();

        switch (deleteEmployeeBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteEmployeeBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteEmployeeBenefit.getInitObject());
        }
    }

}
