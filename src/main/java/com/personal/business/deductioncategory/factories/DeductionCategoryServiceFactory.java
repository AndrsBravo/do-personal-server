package com.personal.business.deductioncategory.factories;

import com.personal.business.deductioncategory.create.services.CreateDeductionCategoryService;
import com.personal.business.deductioncategory.delete.services.DeleteDeductionCategoryService;
import com.personal.business.deductioncategory.filter.services.FilterDeductionCategoryService;
import com.personal.business.deductioncategory.update.services.EditDeductionCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class DeductionCategoryServiceFactory {

    public static CreateDeductionCategoryService CreateDeductionCategory(String dbClient) {

        return new CreateDeductionCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterDeductionCategoryService FilterDeductionCategory(String dbClient) {

        return new FilterDeductionCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditDeductionCategoryService EditDeductionCategory(String dbClient) {

        return new EditDeductionCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteDeductionCategoryService DeleteDeductionCategory(String dbClient) {

        return new DeleteDeductionCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
