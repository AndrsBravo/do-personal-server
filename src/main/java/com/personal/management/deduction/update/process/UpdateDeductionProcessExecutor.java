package com.personal.management.deduction.update.process;

import com.personal.management.deduction.entities.Deduction;
import com.personal.management.deduction.update.process.rules.UpdateFieldsParamsDeductionRule;
import com.personal.management.deduction.update.process.rules.UpdateDeductionRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateDeductionProcessExecutor extends SupplierProcessExecutor<UpdateDeductionProcess, Deduction> {

    public UpdateDeductionProcessExecutor() {
        super(new UpdateDeductionProcess(),
                UpdateFieldsParamsDeductionRule::new,
                UpdateDeductionRule::new
        );
    }

    public static UpdateDeductionProcessExecutor builder() {
        return new UpdateDeductionProcessExecutor();
    }

}
