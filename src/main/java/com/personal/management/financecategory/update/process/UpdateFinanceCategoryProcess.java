package com.personal.management.financecategory.update.process;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcess;

public class UpdateFinanceCategoryProcess extends SupplierProcess<FinanceCategory> {

    public UpdateFinanceCategoryProcess() {
        super("update_finance_category_process");
    }

}
