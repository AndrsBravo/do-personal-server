package com.personal.business.employeescale.delete.routes;

import com.personal.business.employeescale.delete.process.DeleteEmployeeScaleProcessExecutor;
import com.personal.business.employeescale.entities.EmployeeScale;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteEmployeeScaleHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var employeeScale = new EmployeeScale(id);

        var deleteEmployeeScale = DeleteEmployeeScaleProcessExecutor.builder()
                .init(employeeScale)
                .execute();

        switch (deleteEmployeeScale.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteEmployeeScale.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteEmployeeScale.getInitObject());
        }
    }

}
