package com.personal.management.orghierarchy.factories;

import com.personal.management.orghierarchy.create.services.CreateOrgHierarchyService;
import com.personal.management.orghierarchy.delete.services.DeleteOrgHierarchyService;
import com.personal.management.orghierarchy.filter.services.FilterOrgHierarchyService;
import com.personal.management.orghierarchy.update.services.EditOrgHierarchyService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OrgHierarchyServiceFactory {

    public static CreateOrgHierarchyService CreateOrgHierarchy() {

        return new CreateOrgHierarchyService(DbClientMSSQLFactory.Management());
    }

    public static FilterOrgHierarchyService FilterOrgHierarchy() {

        return new FilterOrgHierarchyService(DbClientMSSQLFactory.Management());
    }

    public static EditOrgHierarchyService EditOrgHierarchy() {

        return new EditOrgHierarchyService(DbClientMSSQLFactory.Management());
    }

    public static DeleteOrgHierarchyService DeleteOrgHierarchy() {

        return new DeleteOrgHierarchyService(DbClientMSSQLFactory.Management());
    }

}
