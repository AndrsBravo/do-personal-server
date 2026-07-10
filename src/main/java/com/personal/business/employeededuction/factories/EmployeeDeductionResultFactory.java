package com.personal.business.employeededuction.factories;

import java.util.List;

import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.employeededuction.notifications.EmployeeDeductionNotificationFactory;
import com.personal.shared.services.entities.ServiceResult;

public class EmployeeDeductionResultFactory {

    public static ServiceResult<EmployeeDeduction> CreateFail() {
        return new ServiceResult<>(EmployeeDeductionNotificationFactory.CreateEmployeeDeductionFail(), null);
    }

    public static ServiceResult<EmployeeDeduction> CreateSuccess(EmployeeDeduction employeeDeduction) {
        return new ServiceResult<>(null, employeeDeduction);
    }

    public static ServiceResult<EmployeeDeduction> UpdateFail() {
        return new ServiceResult<>(EmployeeDeductionNotificationFactory.UpdateEmployeeDeductionFail(), null);
    }

    public static ServiceResult<EmployeeDeduction> UpdateSuccess(EmployeeDeduction employeeDeduction) {
        return new ServiceResult<>(null, employeeDeduction);
    }

    public static ServiceResult<EmployeeDeduction> DeleteSuccess(EmployeeDeduction employeeDeduction) {
        return new ServiceResult<>(null, employeeDeduction);
    }

    public static ServiceResult<EmployeeDeduction> DeleteFail() {
        return new ServiceResult<>(EmployeeDeductionNotificationFactory.DeleteEmployeeDeductionFail(), null);
    }

    public static ServiceResult<List<EmployeeDeduction>> FetchNull() {
        return new ServiceResult<>(EmployeeDeductionNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<EmployeeDeduction>> FetchResult(List<EmployeeDeduction> employeeDeduction) {
        return new ServiceResult<>(null, employeeDeduction);
    }

}
