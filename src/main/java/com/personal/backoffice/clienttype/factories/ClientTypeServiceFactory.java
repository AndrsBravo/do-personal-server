package com.personal.backoffice.clienttype.factories;

import com.personal.backoffice.clienttype.create.services.CreateClientTypeService;
import com.personal.backoffice.clienttype.delete.services.DeleteClientTypeService;
import com.personal.backoffice.clienttype.filter.services.FilterClientTypeService;
import com.personal.backoffice.clienttype.update.services.EditClientTypeService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class ClientTypeServiceFactory {

    public static CreateClientTypeService CreateClientType() {

        return new CreateClientTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterClientTypeService FilterClientTypes() {

        return new FilterClientTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditClientTypeService EditClientType() {

        return new EditClientTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteClientTypeService DeleteClientType() {

        return new DeleteClientTypeService(DbClientMSSQLFactory.SystemMaster());
    }

}
