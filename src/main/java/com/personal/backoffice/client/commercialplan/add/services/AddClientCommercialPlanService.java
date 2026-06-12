package com.personal.backoffice.client.commercialplan.add.services;

import java.util.Optional;

import com.personal.backoffice.client.entities.ClientCommercialPlan;
import com.personal.backoffice.client.factories.ClientResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class AddClientCommercialPlanService implements ICreateService<ClientCommercialPlan> {

    private final Optional<DbClient> dbClient;

    public AddClientCommercialPlanService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<ClientCommercialPlan> create(Query query) {
        if (dbClient.isEmpty()) {
            return ClientResultFactory.AddCommercialPlanFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("client_commercial_plan").Get();

        //System.out.println(insertQuery);
        //System.out.println(query.getParams());
        long result = 0;

        try {
            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el Plan Comercial del Cliente " + e.getMessage());
            return ClientResultFactory.AddCommercialPlanFail();
        }

        if (result == 0) {
            return ClientResultFactory.AddCommercialPlanFail();
        }

        return ClientResultFactory.AddCommercialPlanSuccess(new ClientCommercialPlan());

    }

}
