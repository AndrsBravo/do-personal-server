package com.personal.business.orgrelation.factories;

import com.personal.business.orgrelation.create.services.CreateOrgRelationService;
import com.personal.business.orgrelation.delete.services.DeleteOrgRelationService;
import com.personal.business.orgrelation.filter.services.FilterOrgRelationService;
import com.personal.business.orgrelation.update.services.EditOrgRelationService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OrgRelationServiceFactory {

    public static CreateOrgRelationService CreateOrgRelation(String dbClient) {

        return new CreateOrgRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterOrgRelationService FilterOrgRelation(String dbClient) {

        return new FilterOrgRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditOrgRelationService EditOrgRelation(String dbClient) {

        return new EditOrgRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteOrgRelationService DeleteOrgRelation(String dbClient) {

        return new DeleteOrgRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
