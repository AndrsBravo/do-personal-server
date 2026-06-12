package com.personal.business.hierarchydeduction.factories;

import com.personal.business.hierarchydeduction.create.services.CreateHierarchyDeductionService;
import com.personal.business.hierarchydeduction.delete.services.DeleteHierarchyDeductionService;
import com.personal.business.hierarchydeduction.filter.services.FilterHierarchyDeductionService;
import com.personal.business.hierarchydeduction.update.services.EditHierarchyDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class HierarchyDeductionServiceFactory {

    public static CreateHierarchyDeductionService CreateHierarchyDeduction(String dbClient) {

        return new CreateHierarchyDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterHierarchyDeductionService FilterHierarchyDeduction(String dbClient) {

        return new FilterHierarchyDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditHierarchyDeductionService EditHierarchyDeduction(String dbClient) {

        return new EditHierarchyDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteHierarchyDeductionService DeleteHierarchyDeduction(String dbClient) {

        return new DeleteHierarchyDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
