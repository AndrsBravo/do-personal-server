package com.personal.business.deductioncategory.delete.process;

import com.personal.business.deductioncategory.delete.process.rules.DeleteDeductionCategoryRule;
import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteDeductionCategoryProcessExecutor extends SupplierProcessExecutor<DeleteDeductionCategoryProcess, DeductionCategory> {

    public DeleteDeductionCategoryProcessExecutor() {
        super(new DeleteDeductionCategoryProcess(),
                DeleteDeductionCategoryRule::new
        );
    }

    public static DeleteDeductionCategoryProcessExecutor builder() {
        return new DeleteDeductionCategoryProcessExecutor();
    }

}
