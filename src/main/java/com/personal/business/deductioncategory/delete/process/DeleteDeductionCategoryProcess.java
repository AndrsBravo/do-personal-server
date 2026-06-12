package com.personal.business.deductioncategory.delete.process;

import com.personal.business.deductioncategory.entities.DeductionCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteDeductionCategoryProcess extends SupplierProcess<DeductionCategory> {

    public DeleteDeductionCategoryProcess() {
        super("delete_deductions_categoryprocess");
    }

}
