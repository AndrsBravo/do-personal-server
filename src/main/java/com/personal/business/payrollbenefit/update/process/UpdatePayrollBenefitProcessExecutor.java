package com.personal.business.payrollbenefit.update.process;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.business.payrollbenefit.update.process.rules.UpdatePayrollBenefitRule;
import com.personal.business.payrollbenefit.update.process.rules.UpdateFieldsParamsPayrollBenefitRule;
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
