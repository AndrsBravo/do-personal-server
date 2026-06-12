package com.personal.business.employeescale.filter.inputs;

import java.time.LocalDateTime;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterEmployeeScaleInput extends BusinessFilterInputBase {

    private String employeeId;
    private String hierarchyId;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public FilterEmployeeScaleInput() {
        super();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public void setStartedAt(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public LocalDateTime getStartedAt() {
        return started_at;
    }

    public void setEndedAt(LocalDateTime ended_at) {
        this.ended_at = ended_at;
    }

    public LocalDateTime getEndedAt() {
        return ended_at;
    }

}
