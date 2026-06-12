package com.personal.business.benefit.delete.process;

import com.personal.business.benefit.delete.process.rules.DeleteBenefitRule;
import com.personal.business.benefit.entities.Benefit;
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
