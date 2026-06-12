package com.personal.management.orgrelation.factories;

import com.personal.management.orgrelation.create.services.CreateOrgRelationService;
import com.personal.management.orgrelation.delete.services.DeleteOrgRelationService;
import com.personal.management.orgrelation.filter.services.FilterOrgRelationService;
import com.personal.management.orgrelation.update.services.EditOrgRelationService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class OrgRelationServiceFactory {

    public static CreateOrgRelationService CreateOrgRelation() {

        return new CreateOrgRelationService(DbClientMSSQLFactory.Management());
    }

    public static FilterOrgRelationService FilterOrgRelation() {

        return new FilterOrgRelationService(DbClientMSSQLFactory.Management());
    }

    public static EditOrgRelationService EditOrgRelation() {

        return new EditOrgRelationService(DbClientMSSQLFactory.Management());
    }

    public static DeleteOrgRelationService DeleteOrgRelation() {

        return new DeleteOrgRelationService(DbClientMSSQLFactory.Management());
    }

}
