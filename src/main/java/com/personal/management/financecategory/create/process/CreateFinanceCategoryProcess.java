package com.personal.management.financecategory.create.process;

import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcess;

public class CreateFinanceCategoryProcess extends SupplierProcess<FinanceCategory> {

    public CreateFinanceCategoryProcess() {
        super("create_finance_category_process");
    }

}
