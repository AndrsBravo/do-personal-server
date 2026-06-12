package com.personal.backoffice.userrole.factories;

import com.personal.backoffice.userrole.create.services.CreateUserRoleService;
import com.personal.backoffice.userrole.delete.services.DeleteUserRoleService;
import com.personal.backoffice.userrole.filter.services.FilterUserRoleService;
import com.personal.backoffice.userrole.update.services.EditUserRoleService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class UserRoleServiceFactory {

    public static CreateUserRoleService CreateUserRole() {

        return new CreateUserRoleService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterUserRoleService FilterUserRoles() {

        return new FilterUserRoleService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditUserRoleService EditUserRole() {

        return new EditUserRoleService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteUserRoleService DeleteUserRole() {

        return new DeleteUserRoleService(DbClientMSSQLFactory.SystemMaster());
    }

}
