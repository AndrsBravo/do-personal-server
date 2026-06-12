package com.personal.business.employeededuction.factories;

import com.personal.business.employeededuction.create.services.CreateEmployeeDeductionService;
import com.personal.business.employeededuction.delete.services.DeleteEmployeeDeductionService;
import com.personal.business.employeededuction.filter.services.FilterEmployeeDeductionService;
import com.personal.business.employeededuction.update.services.EditEmployeeDeductionService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class EmployeeDeductionServiceFactory {

    public static CreateEmployeeDeductionService CreateEmployeeDeduction(String dbClient) {

        return new CreateEmployeeDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterEmployeeDeductionService FilterEmployeeDeduction(String dbClient) {

        return new FilterEmployeeDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditEmployeeDeductionService EditEmployeeDeduction(String dbClient) {

        return new EditEmployeeDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteEmployeeDeductionService DeleteEmployeeDeduction(String dbClient) {

        return new DeleteEmployeeDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
