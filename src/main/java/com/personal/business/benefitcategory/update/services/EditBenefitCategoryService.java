package com.personal.business.benefitcategory.update.services;

import java.util.Optional;

import com.personal.business.benefitcategory.notifications.BenefitCategoryNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditBenefitCategoryService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditBenefitCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("benefit_categories").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(BenefitCategoryNotificationFactory.UpdateBenefitCategorySuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(BenefitCategoryNotificationFactory.UpdateBenefitCategoryFail());

        }
        return builder.get();
    }

}
