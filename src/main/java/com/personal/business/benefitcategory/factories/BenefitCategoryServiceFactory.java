package com.personal.business.benefitcategory.factories;

import com.personal.business.benefitcategory.create.services.CreateBenefitCategoryService;
import com.personal.business.benefitcategory.delete.services.DeleteBenefitCategoryService;
import com.personal.business.benefitcategory.filter.services.FilterBenefitCategoryService;
import com.personal.business.benefitcategory.update.services.EditBenefitCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitCategoryServiceFactory {

    public static CreateBenefitCategoryService CreateBenefitCategory(String dbClient) {

        return new CreateBenefitCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterBenefitCategoryService FilterBenefitCategory(String dbClient) {

        return new FilterBenefitCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditBenefitCategoryService EditBenefitCategory(String dbClient) {

        return new EditBenefitCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteBenefitCategoryService DeleteBenefitCategory(String dbClient) {

        return new DeleteBenefitCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
