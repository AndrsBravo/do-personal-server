package com.personal.backoffice.commercial.plan.factories;

import com.personal.backoffice.commercial.plan.create.services.CreateCommercialPlanService;
import com.personal.backoffice.commercial.plan.delete.services.DeleteCommercialPlanService;
import com.personal.backoffice.commercial.plan.filter.services.FilterCommercialPlanService;
import com.personal.backoffice.commercial.plan.update.services.EditCommercialPlanService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class CommercialPlanServiceFactory {

    public static CreateCommercialPlanService CreateCommercialPlan() {

        return new CreateCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterCommercialPlanService FilterCommercialPlan() {

        return new FilterCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditCommercialPlanService EditCommercialPlan() {

        return new EditCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteCommercialPlanService DeleteCommercialPlan() {

        return new DeleteCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

}
