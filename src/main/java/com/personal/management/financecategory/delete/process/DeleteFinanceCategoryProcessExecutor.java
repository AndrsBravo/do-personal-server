package com.personal.management.financecategory.delete.process;

import com.personal.management.financecategory.delete.process.rules.DeleteFinanceCategoryRule;
import com.personal.management.financecategory.entities.FinanceCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteFinanceCategoryProcessExecutor extends SupplierProcessExecutor<DeleteFinanceCategoryProcess, FinanceCategory> {

    public DeleteFinanceCategoryProcessExecutor() {
        super(new DeleteFinanceCategoryProcess(),
                DeleteFinanceCategoryRule::new
        );
    }

    public static DeleteFinanceCategoryProcessExecutor builder() {
        return new DeleteFinanceCategoryProcessExecutor();
    }

}
