package com.personal.business.payrollrun.delete.routes;

import com.personal.business.payrollrun.delete.process.DeletePayrollRunProcessExecutor;
import com.personal.business.payrollrun.entities.PayrollRun;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollRunHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollRun = new PayrollRun(id);

        var deletePayrollRun = DeletePayrollRunProcessExecutor.builder()
                .init(payrollRun)
                .execute();

        switch (deletePayrollRun.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollRun.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollRun.getInitObject());
        }
    }

}
