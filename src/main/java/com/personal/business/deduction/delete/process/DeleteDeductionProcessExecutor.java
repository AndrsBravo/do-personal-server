package com.personal.business.deduction.delete.process;

import com.personal.business.deduction.delete.process.rules.DeleteDeductionRule;
import com.personal.business.deduction.entities.Deduction;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteDeductionProcessExecutor extends SupplierProcessExecutor<DeleteDeductionProcess, Deduction> {

    public DeleteDeductionProcessExecutor() {
        super(new DeleteDeductionProcess(),
                DeleteDeductionRule::new
        );
    }

    public static DeleteDeductionProcessExecutor builder() {
        return new DeleteDeductionProcessExecutor();
    }

}
