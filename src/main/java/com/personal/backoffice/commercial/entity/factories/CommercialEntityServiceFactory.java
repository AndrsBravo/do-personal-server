package com.personal.backoffice.commercial.entity.factories;

import com.personal.backoffice.commercial.entity.create.services.CreateCommercialEntityService;
import com.personal.backoffice.commercial.entity.delete.services.DeleteCommercialEntityService;
import com.personal.backoffice.commercial.entity.filter.services.FilterCommercialEntityService;
import com.personal.backoffice.commercial.entity.update.services.EditCommercialEntityService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class CommercialEntityServiceFactory {

    public static CreateCommercialEntityService CreateCommercialEntity() {

        return new CreateCommercialEntityService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterCommercialEntityService FilterCommercialEntity() {

        return new FilterCommercialEntityService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditCommercialEntityService EditCommercialEntity() {

        return new EditCommercialEntityService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteCommercialEntityService DeleteCommercialEntity() {

        return new DeleteCommercialEntityService(DbClientMSSQLFactory.SystemMaster());
    }

}
