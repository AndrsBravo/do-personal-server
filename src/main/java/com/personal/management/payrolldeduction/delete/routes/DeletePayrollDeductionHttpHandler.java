package com.personal.management.payrolldeduction.delete.routes;

import com.personal.management.payrolldeduction.delete.process.DeletePayrollDeductionProcessExecutor;
import com.personal.management.payrolldeduction.entities.PayrollDeduction;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollDeductionHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollDeduction = new PayrollDeduction(id);

        var deletePayrollDeduction = DeletePayrollDeductionProcessExecutor.builder()
                .init(payrollDeduction)
                .execute();

        switch (deletePayrollDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollDeduction.getInitObject());
        }
    }

}
