package com.personal.management.origincategory.create.process;

import com.personal.management.origincategory.create.process.rules.CreateOriginCategoryRule;
import com.personal.management.origincategory.create.process.rules.ValidateOriginCategoryRule;
import com.personal.management.origincategory.entities.OriginCategory;
import com.personal.shared.process.SupplierProcessExecutor;

public class CreateOriginCategoryProcessExecutor extends SupplierProcessExecutor<CreateOriginCategoryProcess, OriginCategory> {

    public CreateOriginCategoryProcessExecutor() {
        super(new CreateOriginCategoryProcess(),
                ValidateOriginCategoryRule::new,
                CreateOriginCategoryRule::new
        );
    }

    public static CreateOriginCategoryProcessExecutor builder() {
        return new CreateOriginCategoryProcessExecutor();
    }

}
