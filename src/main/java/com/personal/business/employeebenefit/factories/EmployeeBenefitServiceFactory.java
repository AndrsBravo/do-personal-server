package com.personal.business.employeebenefit.factories;

import com.personal.business.employeebenefit.create.services.CreateEmployeeBenefitService;
import com.personal.business.employeebenefit.delete.services.DeleteEmployeeBenefitService;
import com.personal.business.employeebenefit.filter.services.FilterEmployeeBenefitService;
import com.personal.business.employeebenefit.update.services.EditEmployeeBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class EmployeeBenefitServiceFactory {

    public static CreateEmployeeBenefitService CreateEmployeeBenefit(String dbClient) {

        return new CreateEmployeeBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterEmployeeBenefitService FilterEmployeeBenefit(String dbClient) {

        return new FilterEmployeeBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditEmployeeBenefitService EditEmployeeBenefit(String dbClient) {

        return new EditEmployeeBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteEmployeeBenefitService DeleteEmployeeBenefit(String dbClient) {

        return new DeleteEmployeeBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
