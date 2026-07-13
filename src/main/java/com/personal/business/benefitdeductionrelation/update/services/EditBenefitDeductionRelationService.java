package com.personal.business.benefitdeductionrelation.update.services;

import java.util.Optional;

import com.personal.business.benefitdeductionrelation.notifications.BenefitDeductionRelationNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditBenefitDeductionRelationService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("benefits_deductions_base").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationFail());

        }
        return builder.get();
    }

}
