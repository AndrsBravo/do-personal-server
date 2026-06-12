package com.personal.business.employeedeductionfeed.filter.inputs;

import java.time.LocalDateTime;

import com.personal.business.shared.inputs.BusinessFilterInputBase;

public class FilterEmployeeDeductionFeedInput extends BusinessFilterInputBase {

    private String deductionId;
    private String employeeId;
    private String temporalFrequencyId;
    private Double amount;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public FilterEmployeeDeductionFeedInput() {
        super();
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
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
