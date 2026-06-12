package com.personal.management.benefitcategory.update.process;

import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.management.benefitcategory.update.process.rules.UpdateFieldsParamsBenefitCategoryRule;
import com.personal.management.benefitcategory.update.process.rules.UpdateBenefitCategoryRule;
import com.personal.shared.process.SupplierProcessExecutor;

public class UpdateBenefitCategoryProcessExecutor extends SupplierProcessExecutor<UpdateBenefitCategoryProcess, BenefitCategory> {

    public UpdateBenefitCategoryProcessExecutor() {
        super(new UpdateBenefitCategoryProcess(),
                UpdateFieldsParamsBenefitCategoryRule::new,
                UpdateBenefitCategoryRule::new
        );
    }

    public static UpdateBenefitCategoryProcessExecutor builder() {
        return new UpdateBenefitCategoryProcessExecutor();
    }

}
