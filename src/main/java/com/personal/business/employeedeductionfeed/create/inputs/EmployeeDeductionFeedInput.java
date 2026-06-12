package com.personal.business.employeedeductionfeed.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.deduction.entities.Deduction;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeedeductionfeed.entities.EmployeeDeductionFeed;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class EmployeeDeductionFeedInput extends BusinessInputBase {

    private String deductionId;
    private String employeeId;
    private String temporalFrequencyId;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public EmployeeDeductionFeedInput() {
        super();
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeDeductionFeed getEmployeeDeductionFeed() {
        var employeeDeductionFeed = this.id == null || this.id.isEmpty() ? new EmployeeDeductionFeed() : new EmployeeDeductionFeed(this.id);
        employeeDeductionFeed.setDeduction(new Deduction(deductionId));
        employeeDeductionFeed.setEmployee(new Employee(employeeId));
        employeeDeductionFeed.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        employeeDeductionFeed.setAmount(amount);
        employeeDeductionFeed.setStartedAt(started_at);
        employeeDeductionFeed.setEndedAt(ended_at);
        employeeDeductionFeed.setBusiness(this.getBusiness());
        employeeDeductionFeed.setCreatedBy(sessionUser);
        return employeeDeductionFeed;
    }
}
