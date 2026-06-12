package com.personal.management.deductioncategory.update.process;

import com.personal.management.deductioncategory.entities.DeductionCategory;
import com.personal.management.deductioncategory.update.process.rules.UpdateFieldsParamsDeductionCategoryRule;
import com.personal.management.deductioncategory.update.process.rules.UpdateDeductionCategoryRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateDeductionCategoryProcessExecutor extends SupplierProcessExecutor<UpdateDeductionCategoryProcess, DeductionCategory> {

    public UpdateDeductionCategoryProcessExecutor() {
        super(new UpdateDeductionCategoryProcess(),
                UpdateFieldsParamsDeductionCategoryRule::new,
                UpdateDeductionCategoryRule::new
        );
    }

    public static UpdateDeductionCategoryProcessExecutor builder() {
        return new UpdateDeductionCategoryProcessExecutor();
    }

}
