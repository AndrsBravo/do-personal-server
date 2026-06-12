package com.personal.management.payrollrundeduction.delete.routes;

import com.personal.management.payrollrundeduction.delete.process.DeletePayrollRunDeductionProcessExecutor;
import com.personal.management.payrollrundeduction.entities.PayrollRunDeduction;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollRunDeductionHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollRunDeduction = new PayrollRunDeduction(id);

        var deletePayrollRunDeduction = DeletePayrollRunDeductionProcessExecutor.builder()
                .init(payrollRunDeduction)
                .execute();

        switch (deletePayrollRunDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollRunDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollRunDeduction.getInitObject());
        }
    }

}
