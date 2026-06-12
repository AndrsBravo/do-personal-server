package com.personal.business.employeebenefitfeed.filter.inputs;

import java.time.LocalDateTime;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterEmployeeBenefitFeedInput extends BusinessFilterInputBase {

    private String benefitId;
    private String employeeId;
    private String temporalFrequencyId;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public FilterEmployeeBenefitFeedInput() {
        super();
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setTemporalFrequencyId(String temporalFrequencyId) {
        this.temporalFrequencyId = temporalFrequencyId;
    }

    public String getTemporalFrequencyId() {
        return temporalFrequencyId;
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

    public void setStartedAt(LocalDateTime started_at) {
        this.started_at = started_at;
    }

    public void setEndedAt(LocalDateTime ended_at) {
        this.ended_at = ended_at;
    }

    public LocalDateTime getEndedAt() {
        return ended_at;
    }

}
