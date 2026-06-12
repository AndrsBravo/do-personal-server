package com.personal.business.financecategory.factories;

import com.personal.business.financecategory.create.services.CreateFinanceCategoryService;
import com.personal.business.financecategory.delete.services.DeleteFinanceCategoryService;
import com.personal.business.financecategory.filter.services.FilterFinanceCategoryService;
import com.personal.business.financecategory.update.services.EditFinanceCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class FinanceCategoryServiceFactory {

    public static CreateFinanceCategoryService CreateFinanceCategory(String dbClient) {

        return new CreateFinanceCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterFinanceCategoryService FilterFinanceCategory(String dbClient) {

        return new FilterFinanceCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditFinanceCategoryService EditFinanceCategory(String dbClient) {

        return new EditFinanceCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteFinanceCategoryService DeleteFinanceCategory(String dbClient) {

        return new DeleteFinanceCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
