package com.personal.business.benefitdeductionrelation.filter.process.rules;

import com.personal.business.benefitdeductionrelation.factories.BenefitDeductionRelationServiceFactory;
import com.personal.business.benefitdeductionrelation.filter.process.FilterBenefitDeductionRelationProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterBenefitDeductionRelationRule implements IProcessRule<FilterBenefitDeductionRelationProcess> {

    @Override
    public void apply(FilterBenefitDeductionRelationProcess process) {

        var pLogger = LogFactory.builder(FilterBenefitDeductionRelationProcess.class, FilterBenefitDeductionRelationRule.class);
        var query = process.Query();
        var benefitDeductionRelationFilter = process.getInitObject();
        if (benefitDeductionRelationFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (benefitDeductionRelationFilter.getId() != null) {
            query.Field("id", benefitDeductionRelationFilter.getId());
            query.Where().AndEqu("id");
        }

        if (benefitDeductionRelationFilter.getBenefitId() != null) {
            query.Field("business_benefit_id", benefitDeductionRelationFilter.getBenefitId());
            query.Where().AndEqu("business_benefit_id");
        }

        if (benefitDeductionRelationFilter.getDeductionId() != null) {
            query.Field("business_deduction_id", benefitDeductionRelationFilter.getDeductionId());
            query.Where().AndEqu("business_deduction_id");
        }

        var filterBenefitDeductionRelation = BenefitDeductionRelationServiceFactory.FilterBenefitDeductionRelation(benefitDeductionRelationFilter.getBusiness().getDbName());

        var result = filterBenefitDeductionRelation.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
