package com.personal.business.deductioncategory.create.process;

import com.personal.business.deductioncategory.create.process.rules.CreateDeductionCategoryRule;
import com.personal.business.deductioncategory.create.process.rules.ValidateDeductionCategoryRule;
import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateDeductionCategoryProcessExecutor extends SupplierProcessExecutor<CreateDeductionCategoryProcess, DeductionCategory> {

    public CreateDeductionCategoryProcessExecutor() {
        super(new CreateDeductionCategoryProcess(),
                ValidateDeductionCategoryRule::new,
                CreateDeductionCategoryRule::new
        );
    }

    public static CreateDeductionCategoryProcessExecutor builder() {
        return new CreateDeductionCategoryProcessExecutor();
    }

}
