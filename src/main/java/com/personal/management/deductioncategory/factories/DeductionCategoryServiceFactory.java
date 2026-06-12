package com.personal.management.deductioncategory.factories;

import com.personal.management.deductioncategory.create.services.CreateDeductionCategoryService;
import com.personal.management.deductioncategory.delete.services.DeleteDeductionCategoryService;
import com.personal.management.deductioncategory.filter.services.FilterDeductionCategoryService;
import com.personal.management.deductioncategory.update.services.EditDeductionCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class DeductionCategoryServiceFactory {

    public static CreateDeductionCategoryService CreateDeductionCategory() {

        return new CreateDeductionCategoryService(DbClientMSSQLFactory.Management());
    }

    public static FilterDeductionCategoryService FilterDeductionCategory() {

        return new FilterDeductionCategoryService(DbClientMSSQLFactory.Management());
    }

    public static EditDeductionCategoryService EditDeductionCategory() {

        return new EditDeductionCategoryService(DbClientMSSQLFactory.Management());
    }

    public static DeleteDeductionCategoryService DeleteDeductionCategory() {

        return new DeleteDeductionCategoryService(DbClientMSSQLFactory.Management());
    }

}
