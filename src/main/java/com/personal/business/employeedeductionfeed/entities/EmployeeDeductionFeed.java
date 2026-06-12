package com.personal.business.employeedeductionfeed.entities;

import java.time.LocalDateTime;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeededuction.entities.EmployeeDeduction;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.BusinessEntity;

public class EmployeeDeductionFeed extends BusinessEntity {

    private Deduction deduction;
    private EmployeeDeduction employeeDeduction;
    private Employee employee;
    private TemporalFrequency temporalFrequency;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public EmployeeDeductionFeed() {
        super();
    }

    public EmployeeDeductionFeed(String id) {
        super(id);
    }

    public Deduction getDeduction() {
        return deduction;
    }

    public void setDeduction(Deduction deduction) {
        this.deduction = deduction;
    }

    public EmployeeDeduction getEmployeeDeduction() {
        return employeeDeduction;
    }

    public void setEmployeeDeduction(EmployeeDeduction employeeDeduction) {
        this.employeeDeduction = employeeDeduction;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TemporalFrequency getTemporalFrequency() {
        return temporalFrequency;
    }

    public void setTemporalFrequency(TemporalFrequency temporalFrequency) {
        this.temporalFrequency = temporalFrequency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStartedAt() {
        return started_at;
    }

    public LocalDateTime getEndedAt() {
        return ended_at;
    }

    public void setStartedAt(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public void setEndedAt(LocalDateTime ended_at) {
        this.ended_at = ended_at;
    }
}
