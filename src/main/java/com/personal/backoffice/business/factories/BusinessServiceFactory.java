package com.personal.backoffice.business.factories;

import com.personal.backoffice.business.services.CreateBusinessService;
import com.personal.backoffice.business.services.DeleteBusinessService;
import com.personal.backoffice.business.services.EditBusinessService;
import com.personal.backoffice.business.services.FilterBusinessService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BusinessServiceFactory {

    public static CreateBusinessService CreateBusiness() {

        return new CreateBusinessService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterBusinessService FilterBusiness() {

        return new FilterBusinessService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditBusinessService EditBusiness() {

        return new EditBusinessService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteBusinessService DeleteBusiness() {

        return new DeleteBusinessService(DbClientMSSQLFactory.SystemMaster());
    }

}
