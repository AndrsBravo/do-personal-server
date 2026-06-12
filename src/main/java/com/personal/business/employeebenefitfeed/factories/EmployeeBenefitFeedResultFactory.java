package com.personal.business.employeebenefitfeed.factories;

import java.util.List;

import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.employeebenefitfeed.notifications.EmployeeBenefitFeedNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class EmployeeBenefitFeedResultFactory {

    public static ServiceResult<EmployeeBenefitFeed> CreateFail() {
        return new ServiceResult<>(EmployeeBenefitFeedNotificationFactory.CreateEmployeeBenefitFeedFail(), null);
    }

    public static ServiceResult<EmployeeBenefitFeed> CreateSuccess(EmployeeBenefitFeed employeeBenefitFeed) {
        return new ServiceResult<>(null, employeeBenefitFeed);
    }

    public static ServiceResult<EmployeeBenefitFeed> UpdateFail() {
        return new ServiceResult<>(EmployeeBenefitFeedNotificationFactory.UpdateEmployeeBenefitFeedFail(), null);
    }

    public static ServiceResult<EmployeeBenefitFeed> UpdateSuccess(EmployeeBenefitFeed employeeBenefitFeed) {
        return new ServiceResult<>(null, employeeBenefitFeed);
    }

    public static ServiceResult<EmployeeBenefitFeed> DeleteSuccess(EmployeeBenefitFeed employeeBenefitFeed) {
        return new ServiceResult<>(null, employeeBenefitFeed);
    }

    public static ServiceResult<EmployeeBenefitFeed> DeleteFail() {
        return new ServiceResult<>(EmployeeBenefitFeedNotificationFactory.DeleteEmployeeBenefitFeedFail(), null);
    }

    public static ServiceResult<List<EmployeeBenefitFeed>> FetchNull() {
        return new ServiceResult<>(EmployeeBenefitFeedNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<EmployeeBenefitFeed>> FetchResult(List<EmployeeBenefitFeed> employeeBenefitFeed) {
        return new ServiceResult<>(null, employeeBenefitFeed);
    }

}
