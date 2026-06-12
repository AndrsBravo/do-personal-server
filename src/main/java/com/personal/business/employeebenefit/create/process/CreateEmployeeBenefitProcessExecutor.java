package com.personal.business.employeebenefit.create.process;

import com.personal.business.employeebenefit.create.process.rules.CreateEmployeeBenefitRule;
import com.personal.business.employeebenefit.create.process.rules.ValidateEmployeeBenefitRule;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateEmployeeBenefitProcessExecutor extends SupplierProcessExecutor<CreateEmployeeBenefitProcess, EmployeeBenefit> {

    public CreateEmployeeBenefitProcessExecutor() {
        super(new CreateEmployeeBenefitProcess(),
                ValidateEmployeeBenefitRule::new,
                CreateEmployeeBenefitRule::new
        );
    }

    public static CreateEmployeeBenefitProcessExecutor builder() {
        return new CreateEmployeeBenefitProcessExecutor();
    }

}
