package com.personal.business.payrollruntype.create.process;

import com.personal.business.payrollruntype.create.process.rules.CreatePayrollRunTypeRule;
import com.personal.business.payrollruntype.create.process.rules.ValidatePayrollRunTypeRule;
import com.personal.business.shared.entities.TypeEntity;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreatePayrollRunTypeProcessExecutor extends SupplierProcessExecutor<CreatePayrollRunTypeProcess, TypeEntity> {

    public CreatePayrollRunTypeProcessExecutor() {
        super(new CreatePayrollRunTypeProcess(),
                ValidatePayrollRunTypeRule::new,
                CreatePayrollRunTypeRule::new
        );
    }

    public static CreatePayrollRunTypeProcessExecutor builder() {
        return new CreatePayrollRunTypeProcessExecutor();
    }

}
