package com.personal.management.payrollbenefit.delete.process;

import com.personal.management.payrollbenefit.delete.process.rules.DeletePayrollBenefitRule;
import com.personal.management.payrollbenefit.entities.PayrollBenefit;
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
