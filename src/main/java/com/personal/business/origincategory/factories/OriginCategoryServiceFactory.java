package com.personal.business.origincategory.factories;

import com.personal.business.origincategory.create.services.CreateOriginCategoryService;
import com.personal.business.origincategory.delete.services.DeleteOriginCategoryService;
import com.personal.business.origincategory.filter.services.FilterOriginCategoryService;
import com.personal.business.origincategory.update.services.EditOriginCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OriginCategoryServiceFactory {

    public static CreateOriginCategoryService CreateOriginCategory(String dbClient) {

        return new CreateOriginCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterOriginCategoryService FilterOriginCategory(String dbClient) {

        return new FilterOriginCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditOriginCategoryService EditOriginCategory(String dbClient) {

        return new EditOriginCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteOriginCategoryService DeleteOriginCategory(String dbClient) {

        return new DeleteOriginCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
