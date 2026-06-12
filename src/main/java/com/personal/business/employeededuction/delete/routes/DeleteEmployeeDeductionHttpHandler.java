package com.personal.business.employeededuction.delete.routes;

import com.personal.business.employeededuction.delete.process.DeleteEmployeeDeductionProcessExecutor;
import com.personal.business.employeededuction.entities.EmployeeDeduction;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteEmployeeDeductionHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var employeeDeduction = new EmployeeDeduction(id);

        var deleteEmployeeDeduction = DeleteEmployeeDeductionProcessExecutor.builder()
                .init(employeeDeduction)
                .execute();

        switch (deleteEmployeeDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteEmployeeDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteEmployeeDeduction.getInitObject());
        }
    }

}
