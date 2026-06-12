package com.personal.business.payrollbenefit.delete.process;

import com.personal.business.payrollbenefit.delete.process.rules.DeletePayrollBenefitRule;
import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeletePayrollBenefitProcessExecutor extends SupplierProcessExecutor<DeletePayrollBenefitProcess, PayrollBenefit> {

    public DeletePayrollBenefitProcessExecutor() {
        super(new DeletePayrollBenefitProcess(),
                DeletePayrollBenefitRule::new
        );
    }

    public static DeletePayrollBenefitProcessExecutor builder() {
        return new DeletePayrollBenefitProcessExecutor();
    }

}
