package com.personal.management.payrollbenefit.update.routes;

import com.personal.management.payrollbenefit.create.inputs.PayrollBenefitInput;
import com.personal.management.payrollbenefit.update.process.UpdatePayrollBenefitProcessExecutor;

import io.helidon.http.Status;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class UpdatePayrollBenefitHttpHandler {

    public void Put(ServerRequest request, ServerResponse response) {
        var payrollBenefit = request.content().as(PayrollBenefitInput.class);

        var updatePayrollBenefit = UpdatePayrollBenefitProcessExecutor.builder()
                .init(payrollBenefit.getPayrollBenefit())
                .execute();

        switch (updatePayrollBenefit.state()) {
            case COMPLETED ->
                response.status(Status.OK_200).send(updatePayrollBenefit.getInitObject());

            default ->
                response.status(Status.ACCEPTED_202).send(updatePayrollBenefit.getInitObject());
        }
    }

}
