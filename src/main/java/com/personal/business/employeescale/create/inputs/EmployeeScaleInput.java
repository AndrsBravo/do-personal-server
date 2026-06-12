package com.personal.business.employeescale.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.employee.entities.Employee;
import com.personal.business.employeescale.entities.EmployeeScale;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.inputs.BusinessInputBase;

public class EmployeeScaleInput extends BusinessInputBase {

    private String employeeId;
    private String hierarchyId;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public EmployeeScaleInput() {
        super();
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public EmployeeScale getEmployeeScale() {
        var employeeScale = this.id == null || this.id.isEmpty() ? new EmployeeScale() : new EmployeeScale(this.id);
        employeeScale.setEmployee(new Employee(employeeId));
        employeeScale.setHierarchy(new Hierarchy(hierarchyId));
        employeeScale.setStartedAt(started_at);
        employeeScale.setEndedAt(ended_at);;
        employeeScale.setBusiness(this.getBusiness());
        employeeScale.setCreatedBy(sessionUser);
        return employeeScale;
    }
}
