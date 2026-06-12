package com.personal.business.payrollrunresult.create.process.rules;

import com.personal.business.payrollrunresult.create.process.CreatePayrollRunResultProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class ValidatePayrollRunResultRule implements IProcessRule<CreatePayrollRunResultProcess> {

    @Override
    public void apply(CreatePayrollRunResultProcess process) {

        var pLogger = LogFactory.builder(CreatePayrollRunResultProcess.class, ValidatePayrollRunResultRule.class);
        var query = process.Query();

        var payrollRunResult = process.getInitObject();
        query.Field("id", payrollRunResult.getId());
        query.Field("business_id", payrollRunResult.getBusiness().getId());
        query.Field("payrolls_id", payrollRunResult.getPayroll().getId());
        query.Field("prcr_title", payrollRunResult.getTitle());
        query.Field("prcr_description", payrollRunResult.getDescription());
        query.Field("created_at", payrollRunResult.getCreatedAt().toString());
        query.Field("updated_at", payrollRunResult.getUpdatedAt().toString());
        query.Field("created_by", payrollRunResult.getCreatedBy().getId());

        process.addLog(pLogger.INFO("Crear nueva relación de Usuario", "Relación de Usuario creada con éxito"));

    }

}
