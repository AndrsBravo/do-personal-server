package com.personal.management.benefitdeductionrelation.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.management.benefitdeductionrelation.entities.BenefitDeductionRelation;
import com.personal.management.benefitdeductionrelation.factories.BenefitDeductionRelationResultFactory;
import com.personal.shared.core.entities.SharedBenefit;
import com.personal.shared.core.entities.SharedDeduction;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterBenefitDeductionRelationService implements IFilterService<BenefitDeductionRelation> {

    private final Optional<DbClient> dbClient;

    public FilterBenefitDeductionRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<BenefitDeductionRelation>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return BenefitDeductionRelationResultFactory.FetchNull();
        }

        var queryString = query.Select("benefits_deductions_base",
                "id", "business_benefit_id", "business_deduction_id", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var or = new BenefitDeductionRelation();
                    or.setId(dbRow.column("id").getString());
                    or.setBenefit(new SharedBenefit(dbRow.column("business_benefit_id").getString()));
                    or.setDeduction(new SharedDeduction(dbRow.column("business_deduction_id").getString()));
                    or.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    or.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    or.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return or;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return BenefitDeductionRelationResultFactory.FetchNull();
        }

        return BenefitDeductionRelationResultFactory.FetchResult(result);
    }
}
