package com.personal.backoffice.usertype.factories;

import com.personal.backoffice.usertype.create.services.CreateUserTypeService;
import com.personal.backoffice.usertype.delete.services.DeleteUserTypeService;
import com.personal.backoffice.usertype.filter.services.FilterUserTypeService;
import com.personal.backoffice.usertype.update.services.EditUserTypeService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class UserTypeServiceFactory {

    public static CreateUserTypeService CreateUserType() {

        return new CreateUserTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterUserTypeService FilterUserTypes() {

        return new FilterUserTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditUserTypeService EditUserType() {

        return new EditUserTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteUserTypeService DeleteUserType() {

        return new DeleteUserTypeService(DbClientMSSQLFactory.SystemMaster());
    }

}
