package com.personal.management.benefitrate.factories;

import com.personal.management.benefitrate.create.services.CreateBenefitRateService;
import com.personal.management.benefitrate.delete.services.DeleteBenefitRateService;
import com.personal.management.benefitrate.filter.services.FilterBenefitRateService;
import com.personal.management.benefitrate.update.services.EditBenefitRateService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitRateServiceFactory {

    public static CreateBenefitRateService CreateBenefitRate() {

        return new CreateBenefitRateService(DbClientMSSQLFactory.Management());
    }

    public static FilterBenefitRateService FilterBenefitRate() {

        return new FilterBenefitRateService(DbClientMSSQLFactory.Management());
    }

    public static EditBenefitRateService EditBenefitRate() {

        return new EditBenefitRateService(DbClientMSSQLFactory.Management());
    }

    public static DeleteBenefitRateService DeleteBenefitRate() {

        return new DeleteBenefitRateService(DbClientMSSQLFactory.Management());
    }

}
