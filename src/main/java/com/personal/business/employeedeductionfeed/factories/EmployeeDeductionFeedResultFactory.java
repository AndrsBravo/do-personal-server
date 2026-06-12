package com.personal.business.employeedeductionfeed.factories;

import java.util.List;

import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.employeedeductionfeed.notifications.EmployeeDeductionFeedNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class EmployeeDeductionFeedResultFactory {

    public static ServiceResult<EmployeeDeductionFeed> CreateFail() {
        return new ServiceResult<>(EmployeeDeductionFeedNotificationFactory.CreateEmployeeDeductionFeedFail(), null);
    }

    public static ServiceResult<EmployeeDeductionFeed> CreateSuccess(EmployeeDeductionFeed employeeDeductionFeed) {
        return new ServiceResult<>(null, employeeDeductionFeed);
    }

    public static ServiceResult<EmployeeDeductionFeed> UpdateFail() {
        return new ServiceResult<>(EmployeeDeductionFeedNotificationFactory.UpdateEmployeeDeductionFeedFail(), null);
    }

    public static ServiceResult<EmployeeDeductionFeed> UpdateSuccess(EmployeeDeductionFeed employeeDeductionFeed) {
        return new ServiceResult<>(null, employeeDeductionFeed);
    }

    public static ServiceResult<EmployeeDeductionFeed> DeleteSuccess(EmployeeDeductionFeed employeeDeductionFeed) {
        return new ServiceResult<>(null, employeeDeductionFeed);
    }

    public static ServiceResult<EmployeeDeductionFeed> DeleteFail() {
        return new ServiceResult<>(EmployeeDeductionFeedNotificationFactory.DeleteEmployeeDeductionFeedFail(), null);
    }

    public static ServiceResult<List<EmployeeDeductionFeed>> FetchNull() {
        return new ServiceResult<>(EmployeeDeductionFeedNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<EmployeeDeductionFeed>> FetchResult(List<EmployeeDeductionFeed> employeeDeductionFeed) {
        return new ServiceResult<>(null, employeeDeductionFeed);
    }

}
