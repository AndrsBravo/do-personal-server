package com.personal.management.origincategory.delete.process;

import com.personal.management.origincategory.delete.process.rules.DeleteOriginCategoryRule;
import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class DeleteOriginCategoryProcessExecutor extends SupplierProcessExecutor<DeleteOriginCategoryProcess, OriginCategory> {

    public DeleteOriginCategoryProcessExecutor() {
        super(new DeleteOriginCategoryProcess(),
                DeleteOriginCategoryRule::new
        );
    }

    public static DeleteOriginCategoryProcessExecutor builder() {
        return new DeleteOriginCategoryProcessExecutor();
    }

}
