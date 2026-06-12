package com.personal.business.payrollrunresult.delete.routes;

import com.personal.business.payrollrunresult.delete.process.DeletePayrollRunResultProcessExecutor;
import com.personal.business.payrollrunresult.entities.PayrollRunResult;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollRunResultHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollRunResult = new PayrollRunResult(id);

        var deletePayrollRunResult = DeletePayrollRunResultProcessExecutor.builder()
                .init(payrollRunResult)
                .execute();

        switch (deletePayrollRunResult.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollRunResult.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollRunResult.getInitObject());
        }
    }

}
