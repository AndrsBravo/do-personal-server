package com.personal.business.deductioncategory.update.process;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.business.deductioncategory.update.process.rules.UpdateFieldsParamsDeductionCategoryRule;
import com.personal.business.deductioncategory.update.process.rules.UpdateDeductionCategoryRule;
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
