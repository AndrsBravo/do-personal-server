package com.personal.business.employeescale.factories;

import java.util.List;

import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.employeescale.notifications.EmployeeScaleNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class EmployeeScaleResultFactory {

    public static ServiceResult<EmployeeScale> CreateFail() {
        return new ServiceResult<>(EmployeeScaleNotificationFactory.CreateEmployeeScaleFail(), null);
    }

    public static ServiceResult<EmployeeScale> CreateSuccess(EmployeeScale employeeScale) {
        return new ServiceResult<>(null, employeeScale);
    }

    public static ServiceResult<EmployeeScale> UpdateFail() {
        return new ServiceResult<>(EmployeeScaleNotificationFactory.UpdateEmployeeScaleFail(), null);
    }

    public static ServiceResult<EmployeeScale> UpdateSuccess(EmployeeScale employeeScale) {
        return new ServiceResult<>(null, employeeScale);
    }

    public static ServiceResult<EmployeeScale> DeleteSuccess(EmployeeScale employeeScale) {
        return new ServiceResult<>(null, employeeScale);
    }

    public static ServiceResult<EmployeeScale> DeleteFail() {
        return new ServiceResult<>(EmployeeScaleNotificationFactory.DeleteEmployeeScaleFail(), null);
    }

    public static ServiceResult<List<EmployeeScale>> FetchNull() {
        return new ServiceResult<>(EmployeeScaleNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<EmployeeScale>> FetchResult(List<EmployeeScale> employeeScale) {
        return new ServiceResult<>(null, employeeScale);
    }

}
