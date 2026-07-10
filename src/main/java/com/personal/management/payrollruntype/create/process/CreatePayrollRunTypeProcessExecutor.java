package com.personal.management.payrollruntype.create.process;

import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.management.payrollruntype.create.process.rules.CreatePayrollRunTypeRule;
import com.personal.management.payrollruntype.create.process.rules.ValidatePayrollRunTypeRule;
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
