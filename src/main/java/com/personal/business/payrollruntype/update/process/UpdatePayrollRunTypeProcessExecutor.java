package com.personal.business.payrollruntype.update.process;

import com.personal.business.payrollruntype.update.process.rules.UpdateFieldsParamsPayrollRunTypeRule;
import com.personal.business.payrollruntype.update.process.rules.UpdatePayrollRunTypeRule;
import com.personal.business.shared.entities.TypeEntity;
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
