package com.personal.business.employeebenefitfeed.delete.routes;

import com.personal.business.employeebenefitfeed.delete.process.DeleteEmployeeBenefitFeedProcessExecutor;
import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeleteEmployeeBenefitFeedHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var employeeBenefitFeed = new EmployeeBenefitFeed(id);

        var deleteEmployeeBenefitFeed = DeleteEmployeeBenefitFeedProcessExecutor.builder()
                .init(employeeBenefitFeed)
                .execute();

        switch (deleteEmployeeBenefitFeed.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deleteEmployeeBenefitFeed.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deleteEmployeeBenefitFeed.getInitObject());
        }
    }

}
