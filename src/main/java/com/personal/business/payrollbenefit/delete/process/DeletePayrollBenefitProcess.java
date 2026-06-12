package com.personal.business.payrollbenefit.delete.process;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.shared.process.SupplierProcess;

public class DeletePayrollBenefitProcess extends SupplierProcess<PayrollBenefit> {

    public DeletePayrollBenefitProcess() {
        super("delete_payroll_benefit_process");
    }

}
