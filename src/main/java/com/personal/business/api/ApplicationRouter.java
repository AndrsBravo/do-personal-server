package com.personal.business.api;

import com.personal.business.benefit.api.routers.BenefitRouter;
import com.personal.business.benefitcategory.api.routers.BenefitCategoryRouter;
import com.personal.business.benefitdeductionrelation.api.routers.BenefitDeductionRelationRouter;
import com.personal.business.benefitrate.api.routers.BenefitRateRouter;
import com.personal.business.country.api.routers.CountryRouter;
import com.personal.business.deduction.api.routers.DeductionRouter;
import com.personal.business.deductioncategory.api.routers.DeductionCategoryRouter;
import com.personal.business.deductionrate.api.routers.DeductionRateRouter;
import com.personal.business.employee.api.routers.EmployeeRouter;
import com.personal.business.employeebenefit.api.routers.EmployeeBenefitRouter;
import com.personal.business.employeebenefitfeed.api.routers.EmployeeBenefitFeedRouter;
import com.personal.business.employeededuction.api.routers.EmployeeDeductionRouter;
import com.personal.business.employeedeductionfeed.api.routers.EmployeeDeductionFeedRouter;
import com.personal.business.employeescale.api.routers.EmployeeScaleRouter;
import com.personal.business.financecategory.api.routers.FinanceCategoryRouter;
import com.personal.business.hierarchy.api.routers.HierarchyRouter;
import com.personal.business.hierarchybenefit.api.routers.HierarchyBenefitRouter;
import com.personal.business.hierarchybenefitfeed.api.routers.HierarchyBenefitFeedRouter;
import com.personal.business.hierarchydeduction.api.routers.HierarchyDeductionRouter;
import com.personal.business.hierarchydeductionfeed.api.routers.HierarchyDeductionFeedRouter;
import com.personal.business.orghierarchy.api.routers.OrgHierarchyRouter;
import com.personal.business.orgrelation.api.routers.OrgRelationRouter;
import com.personal.business.orgstructure.api.routers.OrgStructureRouter;
import com.personal.business.origincategory.api.routers.OriginCategoryRouter;
import com.personal.business.payroll.api.routers.PayrollRouter;
import com.personal.business.payrollbenefit.api.routers.PayrollBenefitRouter;
import com.personal.business.payrollcalculation.api.routers.PayrollCalculationRouter;
import com.personal.business.payrollcalculationresult.api.routers.PayrollCalculationResultRouter;
import com.personal.business.payrolldeduction.api.routers.PayrollDeductionRouter;
import com.personal.business.payrollemployee.api.routers.PayrollEmployeeRouter;
import com.personal.business.payrollrun.api.routers.PayrollRunRouter;
import com.personal.business.payrollrunbenefit.api.routers.PayrollRunBenefitRouter;
import com.personal.business.payrollrundeduction.api.routers.PayrollRunDeductionRouter;
import com.personal.business.payrollrunresult.api.routers.PayrollRunResultRouter;
import com.personal.business.payrollruntype.api.routers.PayrollRunTypeRouter;
import com.personal.business.structure.api.routers.StructureRouter;
import com.personal.business.temporalfrequency.api.routers.TemporalFrequencyRouter;

import io.helidon.http.Status;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;

public class ApplicationRouter implements HttpService {

    @Override
    public void routing(HttpRules rules) {
        rules
                .register("/benefits", new BenefitRouter())
                .register("/benefits_categories", new BenefitCategoryRouter())
                .register("/benefits_deductions_relation", new BenefitDeductionRelationRouter())
                .register("/benefits_rates", new BenefitRateRouter())
                .register("/countries", new CountryRouter())
                .register("/deductions", new DeductionRouter())
                .register("/deduction_categories", new DeductionCategoryRouter())
                .register("/deduction_rates", new DeductionRateRouter())
                .register("/employees", new EmployeeRouter())
                .register("/employee_benefits", new EmployeeBenefitRouter())
                .register("/employee_benefits_feeds", new EmployeeBenefitFeedRouter())
                .register("/employee_deductions", new EmployeeDeductionRouter())
                .register("/employee_deductions_feeds", new EmployeeDeductionFeedRouter())
                .register("/employee_scales", new EmployeeScaleRouter())
                .register("/finance_categories", new FinanceCategoryRouter())
                .register("/hierarchies", new HierarchyRouter())
                .register("/hierarchy_benefits", new HierarchyBenefitRouter())
                .register("/hierarchy_benefits_feeds", new HierarchyBenefitFeedRouter())
                .register("/hierarchy_deductions", new HierarchyDeductionRouter())
                .register("/hierarchy_deductions_feeds", new HierarchyDeductionFeedRouter())
                .register("/origin_categories", new OriginCategoryRouter())
                .register("/org_hierarchies", new OrgHierarchyRouter())
                .register("/org_relations", new OrgRelationRouter())
                .register("/org_structures", new OrgStructureRouter())
                .register("/origin_categories", new OriginCategoryRouter())
                .register("/payrolls", new PayrollRouter())
                .register("/payroll_benefits", new PayrollBenefitRouter())
                .register("/payroll_calculations", new PayrollCalculationRouter())
                .register("/payroll_calculations_results", new PayrollCalculationResultRouter())
                .register("/payroll_deductions", new PayrollDeductionRouter())
                .register("/payroll_employees", new PayrollEmployeeRouter())
                .register("/payroll_runs", new PayrollRunRouter())
                .register("/payroll_runs_benefits", new PayrollRunBenefitRouter())
                .register("/payroll_runs_deductions", new PayrollRunDeductionRouter())
                .register("/payroll_runs_results", new PayrollRunResultRouter())
                .register("/payroll_runs_types", new PayrollRunTypeRouter())
                .register("/structures", new StructureRouter())
                .register("/temporal_frequencies", new TemporalFrequencyRouter())
                .get((req, res) -> {

                    res.status(Status.OK_200).send("Hola desde al App routing");

                });
    }

}
