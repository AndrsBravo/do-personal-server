package com.personal.backoffice.userrelation.factories;

import com.personal.backoffice.userrelation.create.services.CreateUserRelationService;
import com.personal.backoffice.userrelation.delete.services.DeleteUserRelationService;
import com.personal.backoffice.userrelation.filter.services.FilterUserRelationService;
import com.personal.backoffice.userrelation.update.services.EditUserRelationService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class UserRelationServiceFactory {

    public static CreateUserRelationService CreateUserRelation() {

        return new CreateUserRelationService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterUserRelationService FilterUserRelations() {

        return new FilterUserRelationService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditUserRelationService EditUserRelation() {

        return new EditUserRelationService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteUserRelationService DeleteUserRelation() {

        return new DeleteUserRelationService(DbClientMSSQLFactory.SystemMaster());
    }

}
