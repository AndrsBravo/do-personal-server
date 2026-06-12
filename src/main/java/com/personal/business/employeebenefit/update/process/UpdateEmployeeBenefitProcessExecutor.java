package com.personal.business.employeebenefit.update.process;

import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.employeebenefit.update.process.rules.UpdateEmployeeBenefitRule;
import com.personal.business.employeebenefit.update.process.rules.UpdateFieldsParamsEmployeeBenefitRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateEmployeeBenefitProcessExecutor extends SupplierProcessExecutor<UpdateEmployeeBenefitProcess, EmployeeBenefit> {

    public UpdateEmployeeBenefitProcessExecutor() {
        super(new UpdateEmployeeBenefitProcess(),
                UpdateFieldsParamsEmployeeBenefitRule::new,
                UpdateEmployeeBenefitRule::new
        );
    }

    public static UpdateEmployeeBenefitProcessExecutor builder() {
        return new UpdateEmployeeBenefitProcessExecutor();
    }

}
