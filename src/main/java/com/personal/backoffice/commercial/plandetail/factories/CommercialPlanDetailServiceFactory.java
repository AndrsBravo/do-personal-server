package com.personal.backoffice.commercial.plandetail.factories;

import com.personal.backoffice.commercial.plandetail.create.services.CreateCommercialPlanDetailService;
import com.personal.backoffice.commercial.plandetail.delete.services.DeleteCommercialPlanDetailService;
import com.personal.backoffice.commercial.plandetail.filter.services.FilterCommercialPlanDetailService;
import com.personal.backoffice.commercial.plandetail.update.services.EditCommercialPlanDetailService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class CommercialPlanDetailServiceFactory {

    public static CreateCommercialPlanDetailService CreateCommercialPlanDetail() {

        return new CreateCommercialPlanDetailService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterCommercialPlanDetailService FilterCommercialPlanDetail() {

        return new FilterCommercialPlanDetailService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditCommercialPlanDetailService EditCommercialPlanDetail() {

        return new EditCommercialPlanDetailService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteCommercialPlanDetailService DeleteCommercialPlanDetail() {

        return new DeleteCommercialPlanDetailService(DbClientMSSQLFactory.SystemMaster());
    }

}
