package com.personal.business.employeebenefit.update.process.rules;

import com.personal.business.employeebenefit.update.process.UpdateEmployeeBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class UpdateFieldsParamsEmployeeBenefitRule implements IProcessRule<UpdateEmployeeBenefitProcess> {

    @Override
    public void apply(UpdateEmployeeBenefitProcess process) {

        var pLogger = LogFactory.builder(UpdateEmployeeBenefitProcess.class, UpdateFieldsParamsEmployeeBenefitRule.class);

        var query = process.Query();

        var employeeBenefit = process.getInitObject();

        query.Field("id", employeeBenefit.getId());
        query.Where().Equ("id");

        if (employeeBenefit.getBenefit() != null) {
            query.Set("business_benefits_id", employeeBenefit.getBenefit().getId());
        }
        if (employeeBenefit.getEmployee() != null) {
            query.Set("employees_id", employeeBenefit.getEmployee().getId());
        }
        process.addLog(pLogger.INFO("Validar campos de Tipo de Usuario", "Los campos 'type' y 'description' son obligatorios"));

    }
}
