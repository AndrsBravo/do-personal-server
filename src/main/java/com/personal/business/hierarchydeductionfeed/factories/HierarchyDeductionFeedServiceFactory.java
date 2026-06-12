package com.personal.business.hierarchydeductionfeed.factories;

import com.personal.business.hierarchydeductionfeed.create.services.CreateHierarchyDeductionFeedService;
import com.personal.business.hierarchydeductionfeed.delete.services.DeleteHierarchyDeductionFeedService;
import com.personal.business.hierarchydeductionfeed.filter.services.FilterHierarchyDeductionFeedService;
import com.personal.business.hierarchydeductionfeed.update.services.EditHierarchyDeductionFeedService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class HierarchyDeductionFeedServiceFactory {

    public static CreateHierarchyDeductionFeedService CreateHierarchyDeductionFeed(String dbClient) {

        return new CreateHierarchyDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterHierarchyDeductionFeedService FilterHierarchyDeductionFeed(String dbClient) {

        return new FilterHierarchyDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditHierarchyDeductionFeedService EditHierarchyDeductionFeed(String dbClient) {

        return new EditHierarchyDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteHierarchyDeductionFeedService DeleteHierarchyDeductionFeed(String dbClient) {

        return new DeleteHierarchyDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
