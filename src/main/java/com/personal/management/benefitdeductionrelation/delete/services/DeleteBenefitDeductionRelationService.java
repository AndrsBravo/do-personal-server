package com.personal.management.benefitdeductionrelation.delete.services;

import java.util.Optional;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.factories.BenefitDeductionRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteBenefitDeductionRelationService implements IDeleteService<BenefitDeductionRelation> {

    private final Optional<DbClient> dbClient;

    public DeleteBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitDeductionRelation> delete(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitDeductionRelationResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("benefits_deductions_base").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return BenefitDeductionRelationResultFactory.DeleteFail();
        }

        if (result == 0) {
            return BenefitDeductionRelationResultFactory.DeleteFail();
        }

        return BenefitDeductionRelationResultFactory.DeleteSuccess(new BenefitDeductionRelation(query.getParams().get("id")));

    }

}
