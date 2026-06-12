package com.personal.business.orghierarchy.factories;

import com.personal.business.orghierarchy.create.services.CreateOrgHierarchyService;
import com.personal.business.orghierarchy.delete.services.DeleteOrgHierarchyService;
import com.personal.business.orghierarchy.filter.services.FilterOrgHierarchyService;
import com.personal.business.orghierarchy.update.services.EditOrgHierarchyService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OrgHierarchyServiceFactory {

    public static CreateOrgHierarchyService CreateOrgHierarchy(String dbClient) {

        return new CreateOrgHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterOrgHierarchyService FilterOrgHierarchy(String dbClient) {

        return new FilterOrgHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditOrgHierarchyService EditOrgHierarchy(String dbClient) {

        return new EditOrgHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteOrgHierarchyService DeleteOrgHierarchy(String dbClient) {

        return new DeleteOrgHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
