package com.personal.management.orgstructure.factories;

import com.personal.management.orgstructure.create.services.CreateOrgStructureService;
import com.personal.management.orgstructure.delete.services.DeleteOrgStructureService;
import com.personal.management.orgstructure.filter.services.FilterOrgStructureService;
import com.personal.management.orgstructure.update.services.EditOrgStructureService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OrgStructureServiceFactory {

    public static CreateOrgStructureService CreateOrgStructure() {

        return new CreateOrgStructureService(DbClientMSSQLFactory.Management());
    }

    public static FilterOrgStructureService FilterOrgStructure() {

        return new FilterOrgStructureService(DbClientMSSQLFactory.Management());
    }

    public static EditOrgStructureService EditOrgStructure() {

        return new EditOrgStructureService(DbClientMSSQLFactory.Management());
    }

    public static DeleteOrgStructureService DeleteOrgStructure() {

        return new DeleteOrgStructureService(DbClientMSSQLFactory.Management());
    }

}
