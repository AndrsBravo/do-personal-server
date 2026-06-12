package com.personal.management.deductioncategory.delete.process;

import com.personal.management.deductioncategory.entities.DeductionCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteDeductionCategoryProcess extends SupplierProcess<DeductionCategory> {

    public DeleteDeductionCategoryProcess() {
        super("delete_deductions_categoryprocess");
    }

}
