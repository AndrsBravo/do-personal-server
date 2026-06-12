package com.personal.business.hierarchy.factories;

import com.personal.business.hierarchy.create.services.CreateHierarchyService;
import com.personal.business.hierarchy.delete.services.DeleteHierarchyService;
import com.personal.business.hierarchy.filter.services.FilterHierarchyService;
import com.personal.business.hierarchy.update.services.EditHierarchyService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class HierarchyServiceFactory {

    public static CreateHierarchyService CreateHierarchy(String dbClient) {

        return new CreateHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterHierarchyService FilterHierarchy(String dbClient) {

        return new FilterHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditHierarchyService EditHierarchy(String dbClient) {

        return new EditHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteHierarchyService DeleteHierarchy(String dbClient) {

        return new DeleteHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
