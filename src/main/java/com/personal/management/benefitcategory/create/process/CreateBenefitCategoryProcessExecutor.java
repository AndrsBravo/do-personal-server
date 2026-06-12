package com.personal.management.benefitcategory.create.process;

import com.personal.management.benefitcategory.create.process.rules.CreateBenefitCategoryRule;
import com.personal.management.benefitcategory.create.process.rules.ValidateBenefitCategoryRule;
import com.personal.management.benefitcategory.entities.BenefitCategory;
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
