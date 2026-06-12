package com.personal.business.employee.factories;

import java.util.List;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employee.notifications.EmployeeNotificationFactory;
import com.personal.shared.services.ServiceResult;

public class EmployeeResultFactory {

    public static ServiceResult<Employee> CreateFail() {
        return new ServiceResult<>(EmployeeNotificationFactory.CreateEmployeeFail(), null);
    }

    public static ServiceResult<Employee> CreateSuccess(Employee employee) {
        return new ServiceResult<>(null, employee);
    }

    public static ServiceResult<Employee> UpdateFail() {
        return new ServiceResult<>(EmployeeNotificationFactory.UpdateEmployeeFail(), null);
    }

    public static ServiceResult<Employee> UpdateSuccess(Employee employee) {
        return new ServiceResult<>(null, employee);
    }

    public static ServiceResult<Employee> DeleteSuccess(Employee employee) {
        return new ServiceResult<>(null, employee);
    }

    public static ServiceResult<Employee> DeleteFail() {
        return new ServiceResult<>(EmployeeNotificationFactory.DeleteEmployeeFail(), null);
    }

    public static ServiceResult<List<Employee>> FetchNull() {
        return new ServiceResult<>(EmployeeNotificationFactory.FetchNull(), null);
    }

    public static ServiceResult<List<Employee>> FetchResult(List<Employee> employee) {
        return new ServiceResult<>(null, employee);
    }

}
