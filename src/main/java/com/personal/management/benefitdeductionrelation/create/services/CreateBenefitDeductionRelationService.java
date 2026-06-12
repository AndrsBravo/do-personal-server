package com.personal.management.benefitdeductionrelation.create.services;

import java.util.Optional;

import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.factories.BenefitDeductionRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateBenefitDeductionRelationService implements ICreateService<BenefitDeductionRelation> {

    private final Optional<DbClient> dbClient;

    public CreateBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<BenefitDeductionRelation> create(Query query) {
        if (dbClient.isEmpty()) {
            return BenefitDeductionRelationResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("benefits_deductions_base").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return BenefitDeductionRelationResultFactory.CreateFail();
        }

        if (result == 0) {
            return BenefitDeductionRelationResultFactory.CreateFail();
        }

        return BenefitDeductionRelationResultFactory.CreateSuccess(new BenefitDeductionRelation());

    }

}
