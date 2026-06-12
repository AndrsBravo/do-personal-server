package com.personal.business.hierarchybenefit.factories;

import com.personal.business.hierarchybenefit.create.services.CreateHierarchyBenefitService;
import com.personal.business.hierarchybenefit.delete.services.DeleteHierarchyBenefitService;
import com.personal.business.hierarchybenefit.filter.services.FilterHierarchyBenefitService;
import com.personal.business.hierarchybenefit.update.services.EditHierarchyBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class HierarchyBenefitServiceFactory {

    public static CreateHierarchyBenefitService CreateHierarchyBenefit(String dbClient) {

        return new CreateHierarchyBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterHierarchyBenefitService FilterHierarchyBenefit(String dbClient) {

        return new FilterHierarchyBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditHierarchyBenefitService EditHierarchyBenefit(String dbClient) {

        return new EditHierarchyBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteHierarchyBenefitService DeleteHierarchyBenefit(String dbClient) {

        return new DeleteHierarchyBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
