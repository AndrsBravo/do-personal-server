package com.personal.management.payrollrunbenefit.update.routes;

import com.personal.management.payrollrunbenefit.create.inputs.PayrollRunBenefitInput;
import com.personal.management.payrollrunbenefit.update.process.UpdatePayrollRunBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollRunBenefitHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollRunBenefit = request.content().as(PayrollRunBenefitInput.class);

        var updatePayrollRunBenefit = UpdatePayrollRunBenefitProcessExecutor.builder()
                .init(payrollRunBenefit.getPayrollRunBenefit())
                .execute();

        switch (updatePayrollRunBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollRunBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollRunBenefit.getInitObject());
        }
    }

}
