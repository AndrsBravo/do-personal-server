package com.personal.business.financecategory.delete.process;

import com.personal.business.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteFinanceCategoryProcess extends SupplierProcess<FinanceCategory> {

    public DeleteFinanceCategoryProcess() {
        super("delete_finance_category_process");
    }

}
