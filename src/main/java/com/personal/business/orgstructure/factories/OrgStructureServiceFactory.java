package com.personal.business.orgstructure.factories;

import com.personal.business.orgstructure.create.services.CreateOrgStructureService;
import com.personal.business.orgstructure.delete.services.DeleteOrgStructureService;
import com.personal.business.orgstructure.filter.services.FilterOrgStructureService;
import com.personal.business.orgstructure.update.services.EditOrgStructureService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OrgStructureServiceFactory {

    public static CreateOrgStructureService CreateOrgStructure(String dbClient) {

        return new CreateOrgStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterOrgStructureService FilterOrgStructure(String dbClient) {

        return new FilterOrgStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditOrgStructureService EditOrgStructure(String dbClient) {

        return new EditOrgStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteOrgStructureService DeleteOrgStructure(String dbClient) {

        return new DeleteOrgStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
