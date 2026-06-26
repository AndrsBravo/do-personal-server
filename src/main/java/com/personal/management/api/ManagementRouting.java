package com.personal.management.api;

import com.personal.management.benefit.api.routers.BenefitRouter;
import com.personal.management.benefitcategory.api.routers.BenefitCategoryRouter;
import com.personal.management.benefitdeductionrelation.api.routers.BenefitDeductionRelationRouter;
import com.personal.management.benefitrate.api.routers.BenefitRateRouter;
import com.personal.management.country.api.routers.CountryRouter;
import com.personal.management.deduction.api.routers.DeductionRouter;
import com.personal.management.deductioncategory.api.routers.DeductionCategoryRouter;
import com.personal.management.deductionrate.api.routers.DeductionRateRouter;
import com.personal.management.financecategory.api.routers.FinanceCategoryRouter;
import com.personal.management.orghierarchy.api.routers.OrgHierarchyRouter;
import com.personal.management.orgrelation.api.routers.OrgRelationRouter;
import com.personal.management.orgstructure.api.routers.OrgStructureRouter;
import com.personal.management.origincategory.api.routers.OriginCategoryRouter;
import com.personal.management.payroll.api.routers.PayrollRouter;
import com.personal.management.payrollbenefit.api.routers.PayrollBenefitRouter;
import com.personal.management.payrolldeduction.api.routers.PayrollDeductionRouter;
import com.personal.management.payrollrun.api.routers.PayrollRunRouter;
import com.personal.management.payrollrunbenefit.api.routers.PayrollRunBenefitRouter;
import com.personal.management.payrollrundeduction.api.routers.PayrollRunDeductionRouter;
import com.personal.management.payrollruntype.api.routers.PayrollRunTypeRouter;
import com.personal.management.temporalfrequency.api.routers.TemporalFrequencyRouter;

import io.helidon.http.Status;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class ManagementRouting implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules
                .register("/benefits", new BenefitRouter())
                .register("/benefit_categories", new BenefitCategoryRouter())
                .register("/benefit_deduction_relations", new BenefitDeductionRelationRouter())
                .register("/benefit_rates", new BenefitRateRouter())
                .register("/countries", new CountryRouter())
                .register("/deductions", new DeductionRouter())
                .register("/deduction_categories", new DeductionCategoryRouter())
                .register("/deduction_rates", new DeductionRateRouter())
                .register("/finance_categories", new FinanceCategoryRouter())
                .register("/org_hierarchies", new OrgHierarchyRouter())
                .register("/org_structures", new OrgStructureRouter())
                .register("/org_relations", new OrgRelationRouter())
                .register("/origin_categories", new OriginCategoryRouter())
                .register("/payrolls", new PayrollRouter())
                .register("/payroll_benefits", new PayrollBenefitRouter())
                .register("/payroll_deductions", new PayrollDeductionRouter())
                .register("/payroll_runs", new PayrollRunRouter())
                .register("/payroll_runs_benefits", new PayrollRunBenefitRouter())
                .register("/payroll_runs_deductions", new PayrollRunDeductionRouter())
                .register("/payroll_runs_types", new PayrollRunTypeRouter())
                .register("/temporal_frequencies", new TemporalFrequencyRouter())
                .get("/", (req, res) -> {

                    res.status(Status.OK_200).send("Hola desde al Management routing");

                });
    }

}
