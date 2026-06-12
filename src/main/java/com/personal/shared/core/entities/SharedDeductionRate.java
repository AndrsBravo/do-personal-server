package com.personal.shared.core.entities;

import java.time.LocalDateTime;

import com.personal.shared.entities.ShortEntity;

public class SharedDeductionRate extends ShortEntity {

    private SharedDeduction deduction;
    private SharedTemporalFrequency temporalFrequency;
    private Double rate;
    private Double amount;
    private Double base_amount;
    private Byte level;
    private LocalDateTime started_at;
    private LocalDateTime ended_at;

    public SharedDeductionRate() {
        super();
    }

    public SharedDeductionRate(String id) {
        super(id);
    }

    public SharedDeduction getDeduction() {
        return deduction;
    }

    public void setDeduction(SharedDeduction deduction) {
        this.deduction = deduction;
    }

    public SharedTemporalFrequency getTemporalFrequency() {
        return temporalFrequency;
    }

    public void setTemporalFrequency(SharedTemporalFrequency temporalFrequency) {
        this.temporalFrequency = temporalFrequency;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBaseAmount() {
        return base_amount;
    }

    public void setBaseAmount(Double base_amount) {
        this.base_amount = base_amount;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
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
