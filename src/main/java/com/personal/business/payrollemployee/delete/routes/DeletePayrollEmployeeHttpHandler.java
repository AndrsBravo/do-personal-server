package com.personal.business.payrollemployee.delete.routes;

import com.personal.business.payrollemployee.delete.process.DeletePayrollEmployeeProcessExecutor;
import com.personal.business.payrollemployee.entities.PayrollEmployee;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollEmployeeHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollEmployee = new PayrollEmployee(id);

        var deletePayrollEmployee = DeletePayrollEmployeeProcessExecutor.builder()
                .init(payrollEmployee)
                .execute();

        switch (deletePayrollEmployee.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(deletePayrollEmployee.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(deletePayrollEmployee.getInitObject());
        }
    }

}
