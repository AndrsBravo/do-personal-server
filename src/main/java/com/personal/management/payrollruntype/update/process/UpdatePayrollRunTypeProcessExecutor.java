package com.personal.management.payrollruntype.update.process;

import com.personal.backoffice.shared.entities.TypeEntity;
import com.personal.management.payrollruntype.update.process.rules.UpdateFieldsParamsPayrollRunTypeRule;
import com.personal.management.payrollruntype.update.process.rules.UpdatePayrollRunTypeRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdatePayrollRunTypeProcessExecutor extends SupplierProcessExecutor<UpdatePayrollRunTypeProcess, TypeEntity> {

    public UpdatePayrollRunTypeProcessExecutor() {
        super(new UpdatePayrollRunTypeProcess(),
                UpdateFieldsParamsPayrollRunTypeRule::new,
                UpdatePayrollRunTypeRule::new
        );
    }

    public static UpdatePayrollRunTypeProcessExecutor builder() {
        return new UpdatePayrollRunTypeProcessExecutor();
    }

}
