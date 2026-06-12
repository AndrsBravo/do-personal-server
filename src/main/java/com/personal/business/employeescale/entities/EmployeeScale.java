package com.personal.business.employeescale.entities;

import java.time.LocalDateTime;

import com.personal.business.employee.entities.Employee;
import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.shared.entities.BusinessEntity;

public class EmployeeScale extends BusinessEntity {

    private Hierarchy hierarchy;
    private Employee employee;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public EmployeeScale() {
        super();
    }

    public EmployeeScale(String id) {
        super(id);
    }

    public Hierarchy getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Hierarchy hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getStartedAt() {
        return started_at;
    }

    public void setStartedAt(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public LocalDateTime getEndedAt() {
        return ended_at;
    }

    public void setEndedAt(LocalDateTime ended_at) {
        this.ended_at = ended_at;
    }

}
