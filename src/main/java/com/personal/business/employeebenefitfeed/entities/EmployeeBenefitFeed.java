package com.personal.business.employeebenefitfeed.entities;

import java.time.LocalDateTime;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeebenefit.entities.EmployeeBenefit;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.entities.BusinessEntity;

public class EmployeeBenefitFeed extends BusinessEntity {

    private Benefit benefit;
    private EmployeeBenefit employeeBenefit;
    private Employee employee;
    private TemporalFrequency temporalFrequency;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public EmployeeBenefitFeed() {
        super();
    }

    public EmployeeBenefitFeed(String id) {
        super(id);
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }

    public EmployeeBenefit getEmployeeBenefit() {
        return employeeBenefit;
    }

    public void setEmployeeBenefit(EmployeeBenefit employeeBenefit) {
        this.employeeBenefit = employeeBenefit;
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
