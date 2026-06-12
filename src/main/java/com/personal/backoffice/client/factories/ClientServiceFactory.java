package com.personal.backoffice.client.factories;

import com.personal.backoffice.client.commercialplan.add.services.AddClientCommercialPlanService;
import com.personal.backoffice.client.commercialplan.filter.services.FilterClientCommercialPlanService;
import com.personal.backoffice.client.create.services.CreateClientService;
import com.personal.backoffice.client.delete.services.DeleteClientService;
import com.personal.backoffice.client.filter.services.FilterClientService;
import com.personal.backoffice.client.update.services.EditClientService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class ClientServiceFactory {

    public static CreateClientService CreateClient() {

        return new CreateClientService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterClientService FilterClients() {

        return new FilterClientService(DbClientMSSQLFactory.SystemMaster());
    }

    public static EditClientService EditClient() {

        return new EditClientService(DbClientMSSQLFactory.SystemMaster());
    }

    public static DeleteClientService DeleteClient() {

        return new DeleteClientService(DbClientMSSQLFactory.SystemMaster());
    }

    public static AddClientCommercialPlanService AddClientCommercialPlan() {

        return new AddClientCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterClientCommercialPlanService FilterClientCommercialPlan() {

        return new FilterClientCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }
}
