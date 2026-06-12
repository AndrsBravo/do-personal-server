package com.personal.management.payrollbenefit.update.process;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.management.payrollbenefit.update.process.rules.UpdatePayrollBenefitRule;
import com.personal.management.payrollbenefit.update.process.rules.UpdateFieldsParamsPayrollBenefitRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollBenefitProcessExecutor extends SupplierProcessExecutor<UpdatePayrollBenefitProcess, PayrollBenefit> {

    public UpdatePayrollBenefitProcessExecutor() {
        super(new UpdatePayrollBenefitProcess(),
                UpdateFieldsParamsPayrollBenefitRule::new,
                UpdatePayrollBenefitRule::new
        );
    }

    public static UpdatePayrollBenefitProcessExecutor builder() {
        return new UpdatePayrollBenefitProcessExecutor();
    }

}
