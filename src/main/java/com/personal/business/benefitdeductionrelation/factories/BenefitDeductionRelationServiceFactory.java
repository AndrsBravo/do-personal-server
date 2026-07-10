package com.personal.business.benefitdeductionrelation.factories;

import com.personal.business.benefitdeductionrelation.filter.services.FilterBenefitDeductionRelationService;
import com.personal.business.benefitdeductionrelation.notifications.BenefitDeductionRelationNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitDeductionRelationServiceFactory {

    private static final String TABLE_NAME = "benefit_deduction_base";

    public static CreateService CreateBenefitDeductionRelation(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitDeductionRelationNotificationFactory.CreateBenefitDeductionRelationSuccess())
                .withFailureNotification(BenefitDeductionRelationNotificationFactory.CreateBenefitDeductionRelationFail())
                .build();
    }

    public static FilterBenefitDeductionRelationService FilterBenefitDeductionRelation(String dbClient) {

        return new FilterBenefitDeductionRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditBenefitDeductionRelation(String dbClient) {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationSuccess())
                .withFailureNotification(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationFail())
                .build();
    }

    public static DeleteService DeleteBenefitDeductionRelation(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationSuccess())
                .withFailureNotification(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationFail())
                .build();
    }

}
