package com.personal.business.payrollrundeduction.update.routes;

import com.personal.business.payrollrundeduction.create.inputs.PayrollRunDeductionInput;
import com.personal.business.payrollrundeduction.update.process.UpdatePayrollRunDeductionProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollRunDeductionHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollRunDeduction = request.content().as(PayrollRunDeductionInput.class);

        var updatePayrollRunDeduction = UpdatePayrollRunDeductionProcessExecutor.builder()
                .init(payrollRunDeduction.getPayrollRunRunDeduction())
                .execute();

        switch (updatePayrollRunDeduction.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollRunDeduction.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollRunDeduction.getInitObject());
        }
    }

}
