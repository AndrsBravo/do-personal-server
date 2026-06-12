package com.personal.business.employee.delete.routes;

import com.personal.business.employee.delete.process.DeleteEmployeeProcessExecutor;
import com.personal.business.employee.entities.Employee;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteEmployeeHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var employee = new Employee(id);

        var deleteEmployee = DeleteEmployeeProcessExecutor.builder()
                .init(employee)
                .execute();

        switch (deleteEmployee.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteEmployee.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteEmployee.getInitObject());
        }
    }

}
