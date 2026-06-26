package com.personal.business.payrollbenefit.update.process.rules;

import com.personal.business.payrollbenefit.update.process.UpdatePayrollBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollBenefitRule implements IProcessRule<UpdatePayrollBenefitProcess> {

    @Override
    public void apply(UpdatePayrollBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollBenefitProcess.class, UpdateFieldsParamsPayrollBenefitRule.class);

        var query = process.Query();

        var payrollBenefit = process.getInitObject();

        query.Field("id", payrollBenefit.getId());
        query.Where().Equ("id");

        if (payrollBenefit.getBenefit() != null) {
            query.Set("business_benefits_id", payrollBenefit.getBenefit().getId());
        }
        if (payrollBenefit.getPayroll() != null) {
            query.Set("payrolls_id", payrollBenefit.getPayroll().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
