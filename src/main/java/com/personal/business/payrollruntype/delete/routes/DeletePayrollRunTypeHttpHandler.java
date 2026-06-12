package com.personal.business.payrollruntype.delete.routes;

import com.personal.business.payrollruntype.delete.process.DeletePayrollRunTypeProcessExecutor;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.process.ProcessState;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class DeletePayrollRunTypeHttpHandler {

    public void Delete(ServerRequest request, ServerResponse response) {
        var id = request.path().pathParameters().get("id");

        //System.out.println("El id a eliminar " + id);
        var payrollRunType = new TypeEntity(id);

        var deletePayrollRunType = DeletePayrollRunTypeProcessExecutor.builder()
                .init(payrollRunType)
                .execute();

        if (deletePayrollRunType.state() == ProcessState.COMPLETED) {
            response.status(Status.OK_200).send(deletePayrollRunType.getInitObject());
            return;
        }
        response.status(Status.ACCEPTED_202).send(deletePayrollRunType.getInitObject());
    }

}
