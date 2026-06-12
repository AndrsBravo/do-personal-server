package com.personal.management.financecategory.factories;

import com.personal.management.financecategory.create.services.CreateFinanceCategoryService;
import com.personal.management.financecategory.delete.services.DeleteFinanceCategoryService;
import com.personal.management.financecategory.filter.services.FilterFinanceCategoryService;
import com.personal.management.financecategory.update.services.EditFinanceCategoryService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class FinanceCategoryServiceFactory {

    public static CreateFinanceCategoryService CreateFinanceCategory() {

        return new CreateFinanceCategoryService(DbClientMSSQLFactory.Management());
    }

    public static FilterFinanceCategoryService FilterFinanceCategory() {

        return new FilterFinanceCategoryService(DbClientMSSQLFactory.Management());
    }

    public static EditFinanceCategoryService EditFinanceCategory() {

        return new EditFinanceCategoryService(DbClientMSSQLFactory.Management());
    }

    public static DeleteFinanceCategoryService DeleteFinanceCategory() {

        return new DeleteFinanceCategoryService(DbClientMSSQLFactory.Management());
    }

}
