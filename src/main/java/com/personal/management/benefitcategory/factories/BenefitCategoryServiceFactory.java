package com.personal.management.benefitcategory.factories;

import com.personal.management.benefitcategory.create.services.CreateBenefitCategoryService;
import com.personal.management.benefitcategory.delete.services.DeleteBenefitCategoryService;
import com.personal.management.benefitcategory.filter.services.FilterBenefitCategoryService;
import com.personal.management.benefitcategory.update.services.EditBenefitCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitCategoryServiceFactory {

    public static CreateBenefitCategoryService CreateBenefitCategory() {

        return new CreateBenefitCategoryService(DbClientMSSQLFactory.Management());
    }

    public static FilterBenefitCategoryService FilterBenefitCategory() {

        return new FilterBenefitCategoryService(DbClientMSSQLFactory.Management());
    }

    public static EditBenefitCategoryService EditBenefitCategory() {

        return new EditBenefitCategoryService(DbClientMSSQLFactory.Management());
    }

    public static DeleteBenefitCategoryService DeleteBenefitCategory() {

        return new DeleteBenefitCategoryService(DbClientMSSQLFactory.Management());
    }

}
