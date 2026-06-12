package com.personal.management.financecategory.delete.process;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcess;

public class DeleteFinanceCategoryProcess extends SupplierProcess<FinanceCategory> {

    public DeleteFinanceCategoryProcess() {
        super("delete_finance_category_process");
    }

}
