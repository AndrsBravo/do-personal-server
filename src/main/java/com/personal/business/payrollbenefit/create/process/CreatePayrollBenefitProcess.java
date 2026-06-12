package com.personal.business.payrollbenefit.create.process;

import com.personal.business.payrollbenefit.entities.PayrollBenefit;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollBenefitProcess extends SupplierProcess<PayrollBenefit> {

    public CreatePayrollBenefitProcess() {
        super("create_payroll_benefit_process");
    }

}
