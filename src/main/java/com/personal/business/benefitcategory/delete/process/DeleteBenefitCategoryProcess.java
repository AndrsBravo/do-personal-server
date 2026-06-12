package com.personal.business.benefitcategory.delete.process;

import com.personal.business.benefitcategory.entities.BenefitCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteBenefitCategoryProcess extends SupplierProcess<BenefitCategory> {

    public DeleteBenefitCategoryProcess() {
        super("delete_benefit_category_process");
    }

}
