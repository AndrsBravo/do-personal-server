package com.personal.management.benefitdeductionrelation.delete.services;

import java.util.Optional;

import com.personal.management.benefitdeductionrelation.notifications.BenefitDeductionRelationNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteBenefitDeductionRelationService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("benefits_deductions_base").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationFail())
                    .get();
        }
        return builder.get();
    }

}
