package com.personal.business.hierarchybenefit.delete.services;

import java.util.Optional;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.factories.HierarchyBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyBenefitService implements IDeleteService<HierarchyBenefit> {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyBenefit> delete(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyBenefitResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_benefits").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return HierarchyBenefitResultFactory.DeleteFail();
        }

        if (result == 0) {
            return HierarchyBenefitResultFactory.DeleteFail();
        }

        return HierarchyBenefitResultFactory.DeleteSuccess(new HierarchyBenefit(query.getParams().get("id")));

    }

}
