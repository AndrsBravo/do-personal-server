package com.personal.business.employeedeductionfeed.delete.routes;

import com.personal.business.employeedeductionfeed.delete.process.DeleteEmployeeDeductionFeedProcessExecutor;
import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteEmployeeDeductionFeedHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var employeeDeductionFeed = new EmployeeDeductionFeed(id);

        var deleteEmployeeDeductionFeed = DeleteEmployeeDeductionFeedProcessExecutor.builder()
                .init(employeeDeductionFeed)
                .execute();

        switch (deleteEmployeeDeductionFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteEmployeeDeductionFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteEmployeeDeductionFeed.getInitObject());
        }
    }

}
