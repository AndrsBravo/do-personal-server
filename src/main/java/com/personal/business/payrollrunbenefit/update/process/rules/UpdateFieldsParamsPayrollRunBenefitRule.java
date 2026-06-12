package com.personal.business.payrollrunbenefit.update.process.rules;

import com.personal.business.payrollrunbenefit.update.process.UpdatePayrollRunBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsPayrollRunBenefitRule implements IProcessRule<UpdatePayrollRunBenefitProcess> {

    @Override
    public void apply(UpdatePayrollRunBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdatePayrollRunBenefitProcess.class, UpdateFieldsParamsPayrollRunBenefitRule.class);

        var query = process.Query();

        var payrollRunBenefit = process.getInitObject();

        query.Field("id", payrollRunBenefit.getId());
        query.Where().AndEqu("id");

        if (payrollRunBenefit.getBenefit() != null) {
            query.Set("payroll_benefits_id", payrollRunBenefit.getBenefit().getId());
        }
        if (payrollRunBenefit.getPayrollRun() != null) {
            query.Set("payroll_runs_id", payrollRunBenefit.getPayrollRun().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
