package com.personal.business.benefitdeductionrelation.update.services;

import java.util.Optional;

import com.personal.business.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.business.benefitdeductionrelation.factories.BenefitDeductionRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditBenefitDeductionRelationService implements IEditService<BenefitDeductionRelation> {

    private final Optional<DbClient> dbClient;

    public EditBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitDeductionRelation> edit(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitDeductionRelationResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("benefits_deductions_base").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return BenefitDeductionRelationResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return BenefitDeductionRelationResultFactory.UpdateFail();
        }

        return BenefitDeductionRelationResultFactory.UpdateSuccess(new BenefitDeductionRelation());

    }

}
