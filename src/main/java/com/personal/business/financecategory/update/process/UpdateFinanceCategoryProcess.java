package com.personal.business.financecategory.update.process;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcess;

public class UpdateFinanceCategoryProcess extends SupplierProcess<FinanceCategory> {

    public UpdateFinanceCategoryProcess() {
        super("update_finance_category_process");
    }

}
