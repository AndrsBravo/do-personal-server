package com.personal.business.employee.factories;

import com.personal.business.employee.create.services.CreateEmployeeService;
import com.personal.business.employee.delete.services.DeleteEmployeeService;
import com.personal.business.employee.filter.services.FilterEmployeeService;
import com.personal.business.employee.update.services.EditEmployeeService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class EmployeeServiceFactory {

    public static CreateEmployeeService CreateEmployee(String dbClient) {

        return new CreateEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterEmployeeService FilterEmployee(String dbClient) {

        return new FilterEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditEmployeeService EditEmployee(String dbClient) {

        return new EditEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteEmployeeService DeleteEmployee(String dbClient) {

        return new DeleteEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
