package com.personal.business.benefitcategory.create.process;

import com.personal.business.benefitcategory.create.process.rules.CreateBenefitCategoryRule;
import com.personal.business.benefitcategory.create.process.rules.ValidateBenefitCategoryRule;
import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateBenefitCategoryProcessExecutor extends SupplierProcessExecutor<CreateBenefitCategoryProcess, BenefitCategory> {

    public CreateBenefitCategoryProcessExecutor() {
        super(new CreateBenefitCategoryProcess(),
                ValidateBenefitCategoryRule::new,
                CreateBenefitCategoryRule::new
        );
    }

    public static CreateBenefitCategoryProcessExecutor builder() {
        return new CreateBenefitCategoryProcessExecutor();
    }

}
