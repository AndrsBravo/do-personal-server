package com.personal.management.benefitcategory.delete.process;

import com.personal.management.benefitcategory.delete.process.rules.DeleteBenefitCategoryRule;
import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteBenefitCategoryProcessExecutor extends SupplierProcessExecutor<DeleteBenefitCategoryProcess, BenefitCategory> {

    public DeleteBenefitCategoryProcessExecutor() {
        super(new DeleteBenefitCategoryProcess(),
                DeleteBenefitCategoryRule::new
        );
    }

    public static DeleteBenefitCategoryProcessExecutor builder() {
        return new DeleteBenefitCategoryProcessExecutor();
    }

}
