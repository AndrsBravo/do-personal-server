package com.personal.business.employeedeductionfeed.factories;

import com.personal.business.employeedeductionfeed.create.services.CreateEmployeeDeductionFeedService;
import com.personal.business.employeedeductionfeed.delete.services.DeleteEmployeeDeductionFeedService;
import com.personal.business.employeedeductionfeed.filter.services.FilterEmployeeDeductionFeedService;
import com.personal.business.employeedeductionfeed.update.services.EditEmployeeDeductionFeedService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class EmployeeDeductionFeedServiceFactory {

    public static CreateEmployeeDeductionFeedService CreateEmployeeDeductionFeed(String dbClient) {

        return new CreateEmployeeDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterEmployeeDeductionFeedService FilterEmployeeDeductionFeed(String dbClient) {

        return new FilterEmployeeDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditEmployeeDeductionFeedService EditEmployeeDeductionFeed(String dbClient) {

        return new EditEmployeeDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteEmployeeDeductionFeedService DeleteEmployeeDeductionFeed(String dbClient) {

        return new DeleteEmployeeDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
