package com.personal.management.benefit.delete.process;

import com.personal.management.benefit.delete.process.rules.DeleteBenefitRule;
import com.personal.management.benefit.entities.Benefit;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteBenefitProcessExecutor extends SupplierProcessExecutor<DeleteBenefitProcess, Benefit> {

    public DeleteBenefitProcessExecutor() {
        super(new DeleteBenefitProcess(),
                DeleteBenefitRule::new
        );
    }

    public static DeleteBenefitProcessExecutor builder() {
        return new DeleteBenefitProcessExecutor();
    }

}
