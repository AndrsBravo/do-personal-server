package com.personal.business.hierarchybenefit.create.services;

import java.util.Optional;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.factories.HierarchyBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyBenefitService implements ICreateService<HierarchyBenefit> {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyBenefit> create(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyBenefitResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("hierarchies_benefits").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return HierarchyBenefitResultFactory.CreateFail();
        }

        if (result == 0) {
            return HierarchyBenefitResultFactory.CreateFail();
        }

        return HierarchyBenefitResultFactory.CreateSuccess(new HierarchyBenefit());

    }

}
