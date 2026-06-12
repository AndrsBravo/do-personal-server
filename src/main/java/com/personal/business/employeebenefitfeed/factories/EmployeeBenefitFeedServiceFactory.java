package com.personal.business.employeebenefitfeed.factories;

import com.personal.business.employeebenefitfeed.create.services.CreateEmployeeBenefitFeedService;
import com.personal.business.employeebenefitfeed.delete.services.DeleteEmployeeBenefitFeedService;
import com.personal.business.employeebenefitfeed.filter.services.FilterEmployeeBenefitFeedService;
import com.personal.business.employeebenefitfeed.update.services.EditEmployeeBenefitFeedService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class EmployeeBenefitFeedServiceFactory {

    public static CreateEmployeeBenefitFeedService CreateEmployeeBenefitFeed(String dbClient) {

        return new CreateEmployeeBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterEmployeeBenefitFeedService FilterEmployeeBenefitFeed(String dbClient) {

        return new FilterEmployeeBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditEmployeeBenefitFeedService EditEmployeeBenefitFeed(String dbClient) {

        return new EditEmployeeBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteEmployeeBenefitFeedService DeleteEmployeeBenefitFeed(String dbClient) {

        return new DeleteEmployeeBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
