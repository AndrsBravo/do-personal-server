package com.personal.management.payrollrunbenefit.update.process;

import com.personal.management.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.management.payrollrunbenefit.update.process.rules.UpdatePayrollRunBenefitRule;
import com.personal.management.payrollrunbenefit.update.process.rules.UpdateFieldsParamsPayrollRunBenefitRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollRunBenefitProcessExecutor extends SupplierProcessExecutor<UpdatePayrollRunBenefitProcess, PayrollRunBenefit> {

    public UpdatePayrollRunBenefitProcessExecutor() {
        super(new UpdatePayrollRunBenefitProcess(),
                UpdateFieldsParamsPayrollRunBenefitRule::new,
                UpdatePayrollRunBenefitRule::new
        );
    }

    public static UpdatePayrollRunBenefitProcessExecutor builder() {
        return new UpdatePayrollRunBenefitProcessExecutor();
    }

}
