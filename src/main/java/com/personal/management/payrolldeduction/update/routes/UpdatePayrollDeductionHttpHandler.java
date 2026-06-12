package com.personal.management.payrolldeduction.update.routes;

import com.personal.management.payrolldeduction.create.inputs.PayrollDeductionInput;
import com.personal.management.payrolldeduction.update.process.UpdatePayrollDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollDeductionHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollDeduction = request.content().as(PayrollDeductionInput.class);

        var updatePayrollDeduction = UpdatePayrollDeductionProcessExecutor.builder()
                .init(payrollDeduction.getPayrollDeduction())
                .execute();

        switch (updatePayrollDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollDeduction.getInitObject());
        }
    }

}
