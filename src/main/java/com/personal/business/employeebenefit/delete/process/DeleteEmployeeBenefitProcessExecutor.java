package com.personal.business.employeebenefit.delete.process;

import com.personal.business.employeebenefit.delete.process.rules.DeleteEmployeeBenefitRule;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteEmployeeBenefitProcessExecutor extends SupplierProcessExecutor<DeleteEmployeeBenefitProcess, EmployeeBenefit> {

    public DeleteEmployeeBenefitProcessExecutor() {
        super(new DeleteEmployeeBenefitProcess(),
                DeleteEmployeeBenefitRule::new
        );
    }

    public static DeleteEmployeeBenefitProcessExecutor builder() {
        return new DeleteEmployeeBenefitProcessExecutor();
    }

}
