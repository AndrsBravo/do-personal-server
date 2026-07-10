package com.personal.management.benefitdeductionrelation.factories;

import com.personal.management.benefitdeductionrelation.filter.services.FilterBenefitDeductionRelationService;
import com.personal.management.benefitdeductionrelation.notifications.BenefitDeductionRelationNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitDeductionRelationServiceFactory {

    private static final String TABLE_NAME = "benefits_deductions_base";

    public static CreateService CreateBenefitDeductionRelation() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitDeductionRelationNotificationFactory.CreateBenefitDeductionRelationSuccess())
                .withFailureNotification(BenefitDeductionRelationNotificationFactory.CreateBenefitDeductionRelationFail())
                .build();
    }

    public static FilterBenefitDeductionRelationService FilterBenefitDeductionRelation() {

        return new FilterBenefitDeductionRelationService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditBenefitDeductionRelation() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationSuccess())
                .withFailureNotification(BenefitDeductionRelationNotificationFactory.UpdateBenefitDeductionRelationFail())
                .build();
    }

    public static DeleteService DeleteBenefitDeductionRelation() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationSuccess())
                .withFailureNotification(BenefitDeductionRelationNotificationFactory.DeleteBenefitDeductionRelationFail())
                .build();
    }

}
