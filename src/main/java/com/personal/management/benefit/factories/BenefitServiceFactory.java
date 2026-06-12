package com.personal.management.benefit.factories;

import com.personal.management.benefit.create.services.CreateBenefitService;
import com.personal.management.benefit.delete.services.DeleteBenefitService;
import com.personal.management.benefit.filter.services.FilterBenefitService;
import com.personal.management.benefit.update.services.EditBenefitService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class BenefitServiceFactory {

    public static CreateBenefitService CreateBenefit() {

        return new CreateBenefitService(DbClientMSSQLFactory.Management());
    }

    public static FilterBenefitService FilterBenefit() {

        return new FilterBenefitService(DbClientMSSQLFactory.Management());
    }

    public static EditBenefitService EditBenefit() {

        return new EditBenefitService(DbClientMSSQLFactory.Management());
    }

    public static DeleteBenefitService DeleteBenefit() {

        return new DeleteBenefitService(DbClientMSSQLFactory.Management());
    }

}
