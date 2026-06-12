package com.personal.business.employeescale.factories;

import com.personal.business.employeescale.create.services.CreateEmployeeScaleService;
import com.personal.business.employeescale.delete.services.DeleteEmployeeScaleService;
import com.personal.business.employeescale.filter.services.FilterEmployeeScaleService;
import com.personal.business.employeescale.update.services.EditEmployeeScaleService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class EmployeeScaleServiceFactory {

    public static CreateEmployeeScaleService CreateEmployeeScale(String dbClient) {

        return new CreateEmployeeScaleService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterEmployeeScaleService FilterEmployeeScale(String dbClient) {

        return new FilterEmployeeScaleService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditEmployeeScaleService EditEmployeeScale(String dbClient) {

        return new EditEmployeeScaleService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteEmployeeScaleService DeleteEmployeeScale(String dbClient) {

        return new DeleteEmployeeScaleService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
