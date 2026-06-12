package com.personal.management.benefitcategory.delete.process;

import com.personal.management.benefitcategory.entities.BenefitCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteBenefitCategoryProcess extends SupplierProcess<BenefitCategory> {

    public DeleteBenefitCategoryProcess() {
        super("delete_benefit_category_process");
    }

}
