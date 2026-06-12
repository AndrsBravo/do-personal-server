package com.personal.management.origincategory.factories;

import com.personal.management.origincategory.create.services.CreateOriginCategoryService;
import com.personal.management.origincategory.delete.services.DeleteOriginCategoryService;
import com.personal.management.origincategory.filter.services.FilterOriginCategoryService;
import com.personal.management.origincategory.update.services.EditOriginCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OriginCategoryServiceFactory {

    public static CreateOriginCategoryService CreateOriginCategory() {

        return new CreateOriginCategoryService(DbClientMSSQLFactory.Management());
    }

    public static FilterOriginCategoryService FilterOriginCategory() {

        return new FilterOriginCategoryService(DbClientMSSQLFactory.Management());
    }

    public static EditOriginCategoryService EditOriginCategory() {

        return new EditOriginCategoryService(DbClientMSSQLFactory.Management());
    }

    public static DeleteOriginCategoryService DeleteOriginCategory() {

        return new DeleteOriginCategoryService(DbClientMSSQLFactory.Management());
    }

}
