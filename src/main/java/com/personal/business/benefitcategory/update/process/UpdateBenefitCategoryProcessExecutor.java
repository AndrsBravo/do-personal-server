package com.personal.business.benefitcategory.update.process;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.business.benefitcategory.update.process.rules.UpdateFieldsParamsBenefitCategoryRule;
import com.personal.business.benefitcategory.update.process.rules.UpdateBenefitCategoryRule;
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
