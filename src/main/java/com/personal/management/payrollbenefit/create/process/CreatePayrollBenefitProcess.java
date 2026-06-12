package com.personal.management.payrollbenefit.create.process;

import com.personal.management.payrollbenefit.entities.PayrollBenefit;
import com.personal.shared.process.SupplierProcess;

public class CreatePayrollBenefitProcess extends SupplierProcess<PayrollBenefit> {

    public CreatePayrollBenefitProcess() {
        super("create_payroll_benefit_process");
    }

}
