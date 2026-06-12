package com.personal.business.employeebenefit.create.process.rules;

import com.personal.business.employeebenefit.create.process.CreateEmployeeBenefitProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidateEmployeeBenefitRule implements IProcessRule<CreateEmployeeBenefitProcess> {

    @Override
    public void apply(CreateEmployeeBenefitProcess process) {

        var pLogger = LogFactory.builder(CreateEmployeeBenefitProcess.class, ValidateEmployeeBenefitRule.class);
        var query = process.Query();

        var employeeBenefit = process.getInitObject();
        query.Field("id", employeeBenefit.getId());
        query.Field("business_id", employeeBenefit.getBusiness().getId());
        query.Field("employees_id", employeeBenefit.getEmployee().getId());
        query.Field("business_benefits_id", employeeBenefit.getBenefit().getId());
        query.Field("created_at", employeeBenefit.getCreatedAt().toString());
        query.Field("updated_at", employeeBenefit.getUpdatedAt().toString());
        query.Field("created_by", employeeBenefit.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
