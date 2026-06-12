package com.personal.business.payrollrunbenefit.delete.process;

import com.personal.business.payrollrunbenefit.delete.process.rules.DeletePayrollRunBenefitRule;
import com.personal.business.payrollrunbenefit.entities.PayrollRunBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollRunBenefitProcessExecutor extends SupplierProcessExecutor<DeletePayrollRunBenefitProcess, PayrollRunBenefit> {

    public DeletePayrollRunBenefitProcessExecutor() {
        super(new DeletePayrollRunBenefitProcess(),
                DeletePayrollRunBenefitRule::new
        );
    }

    public static DeletePayrollRunBenefitProcessExecutor builder() {
        return new DeletePayrollRunBenefitProcessExecutor();
    }

}
