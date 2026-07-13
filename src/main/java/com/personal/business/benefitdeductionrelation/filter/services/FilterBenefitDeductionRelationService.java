package com.personal.business.benefitdeductionrelation.filter.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.business.benefitdeductionrelation.notifications.BenefitDeductionRelationNotificationFactory;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.entities.EntityBuilder;
import com.personal.shared.query.Query;
import com.personal.shared.services.FilterService;
import com.personal.shared.services.entities.FetchResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitDeductionRelationService extends FilterService<BenefitDeductionRelation> {

    public FilterBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public FetchResult<BenefitDeductionRelation> filter(Query query) {

        if (dbClient.isEmpty()) {
            return builder.NotAvailable();
        }

        var queryString = query.Select("benefits_deductions_base",
                "id", "business_benefit_id", "business_deduction_id", "updated_at", "created_at", "created_by")
                .Get();

        try {
            var result = this.dbClient.get().execute()
                    .createQuery(queryString)
                    .params(query.getParams())
                    .execute()
                    .map((dbRow) -> EntityBuilder.Of(BenefitDeductionRelation::new)
                    .With(BenefitDeductionRelation::setId, dbRow.column("id").getString())
                    .With(BenefitDeductionRelation::setBenefit, new SharedBenefit(dbRow.column("business_benefit_id").getString()))
                    .With(BenefitDeductionRelation::setDeduction, new SharedDeduction(dbRow.column("business_deduction_id").getString()))
                    .With(BenefitDeductionRelation::setCreatedAt, dbRow.column("created_at").get(LocalDateTime.class))
                    .With(BenefitDeductionRelation::setUpdatedAt, dbRow.column("updated_at").get(LocalDateTime.class))
                    .With(BenefitDeductionRelation::setCreatedBy, new User(dbRow.column("created_by").getString()))
                    .Get()).collect(Collectors.toList());

            builder.withResult(result)
                    .withNotification(BenefitDeductionRelationNotificationFactory.FetchBenefitDeductionRelationSuccess());
        } catch (Exception e) {
            builder.withException(e).
                    withNotification(BenefitDeductionRelationNotificationFactory.FetchBenefitDeductionRelationFail());
        }

        return builder.get();
    }
}
