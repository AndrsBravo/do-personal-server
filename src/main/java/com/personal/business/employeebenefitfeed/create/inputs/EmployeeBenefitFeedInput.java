package com.personal.business.employeebenefitfeed.create.inputs;

import java.time.LocalDateTime;

import com.personal.business.benefit.entities.Benefit;
import com.personal.business.employee.entities.Employee;
import com.personal.business.employeebenefitfeed.entities.EmployeeBenefitFeed;
import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.shared.inputs.BusinessInputBase;

public class EmployeeBenefitFeedInput extends BusinessInputBase {

    private String benefitId;
    private String employeeId;
    private String temporalFrequencyId;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public EmployeeBenefitFeedInput() {
        super();
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeBenefitFeed getEmployeeBenefitFeed() {
        var employeeBenefitFeed = this.id == null || this.id.isEmpty() ? new EmployeeBenefitFeed() : new EmployeeBenefitFeed(this.id);
        employeeBenefitFeed.setBenefit(new Benefit(benefitId));
        employeeBenefitFeed.setEmployee(new Employee(employeeId));
        employeeBenefitFeed.setTemporalFrequency(new TemporalFrequency(temporalFrequencyId));
        employeeBenefitFeed.setAmount(amount);
        employeeBenefitFeed.setStartedAt(started_at);
        employeeBenefitFeed.setEndedAt(ended_at);
        employeeBenefitFeed.setBusiness(this.getBusiness());
        employeeBenefitFeed.setCreatedBy(sessionUser);
        return employeeBenefitFeed;
    }
}
