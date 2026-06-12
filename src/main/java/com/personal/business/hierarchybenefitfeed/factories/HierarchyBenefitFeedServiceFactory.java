package com.personal.business.hierarchybenefitfeed.factories;

import com.personal.business.hierarchybenefitfeed.create.services.CreateHierarchyBenefitFeedService;
import com.personal.business.hierarchybenefitfeed.delete.services.DeleteHierarchyBenefitFeedService;
import com.personal.business.hierarchybenefitfeed.filter.services.FilterHierarchyBenefitFeedService;
import com.personal.business.hierarchybenefitfeed.update.services.EditHierarchyBenefitFeedService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class HierarchyBenefitFeedServiceFactory {

    public static CreateHierarchyBenefitFeedService CreateHierarchyBenefitFeed(String dbClient) {

        return new CreateHierarchyBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterHierarchyBenefitFeedService FilterHierarchyBenefitFeed(String dbClient) {

        return new FilterHierarchyBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditHierarchyBenefitFeedService EditHierarchyBenefitFeed(String dbClient) {

        return new EditHierarchyBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteHierarchyBenefitFeedService DeleteHierarchyBenefitFeed(String dbClient) {

        return new DeleteHierarchyBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
