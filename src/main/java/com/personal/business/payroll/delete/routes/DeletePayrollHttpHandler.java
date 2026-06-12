package com.personal.business.payroll.delete.routes;

import com.personal.business.payroll.delete.process.DeletePayrollProcessExecutor;
import com.personal.business.payroll.entities.Payroll;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payroll = new Payroll(id);

        var deletePayroll = DeletePayrollProcessExecutor.builder()
                .init(payroll)
                .execute();

        switch (deletePayroll.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayroll.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayroll.getInitObject());
        }
    }

}
