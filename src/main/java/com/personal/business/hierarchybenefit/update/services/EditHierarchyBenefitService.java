package com.personal.business.hierarchybenefit.update.services;

import java.util.Optional;

import com.personal.business.hierarchybenefit.entities.HierarchyBenefit;
import com.personal.business.hierarchybenefit.factories.HierarchyBenefitResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditHierarchyBenefitService implements IEditService<HierarchyBenefit> {

    private final Optional<DbClient> dbClient;

    public EditHierarchyBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyBenefit> edit(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyBenefitResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("hierarchies_benefits").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return HierarchyBenefitResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return HierarchyBenefitResultFactory.UpdateFail();
        }

        return HierarchyBenefitResultFactory.UpdateSuccess(new HierarchyBenefit());

    }

}
